package com.dotori.golababvoteserver.domain.vote.service;

import com.dotori.golababvoteserver.domain.vote.exception.MealNotFoundException;
import com.dotori.golababvoteserver.domain.vote.dto.RequestDto;
import com.dotori.golababvoteserver.domain.vote.dto.RequestMealDto;
import com.dotori.golababvoteserver.domain.vote.entity.DailyVote;
import com.dotori.golababvoteserver.domain.vote.enum_type.Meal;
import com.dotori.golababvoteserver.domain.vote.entity.TotalVote;
import com.dotori.golababvoteserver.domain.vote.repository.DailyvoteRepository;
import com.dotori.golababvoteserver.domain.vote.repository.TotalVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class MealService {
    private final TotalVoteRepository totalVoteRepository;
    private final DailyvoteRepository dailyvoteRepository;

    // 오늘이 무슨 요일인지 int형으로 반환합니다 ( 월요일 = 1 )
    public int getDateDay() {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        return dayOfWeek.getValue();
    }
    // 아침, 점심, 저녁 Meal타입을 contrller에서 dto로 받지 않고 직접 파라미터에 대입해서 넣어줘서
    // 아침인지 점심인지 저녁인지 구분할 수 있게 합니다
    // 리팩토링 :  어떻게 하면 saveAll을 하지 않고도 controler에서 바로 meal Type을 가져올지, 또는 meal 타입을 어디서 가져올지.
    public void saveAll(RequestDto requestDto, Meal breakfast, Meal lunch, Meal dinner) {
        save(requestDto, breakfast);
        save(requestDto, lunch);

        if(getDateDay() != 5)
        save(requestDto, dinner);
    }
    // 파라미터로 받아온 meal이 아침인지 점심인지 저녁인지 구분하고, 금요일엔 dinner가 나오지 않도록 합니다.
    public void save(RequestDto requestDto, Meal meal) {
        Date date = new Date();
        RequestMealDto requestMeal;
        switch (meal) {
            case BREAKFAST:
                requestMeal = requestDto.getBreakfast();
                break;
            case LUNCH:
                requestMeal = requestDto.getLunch();
                break;
            case DINNER:
                requestMeal = requestDto.getDinner();
                break;
            default:
                throw new MealNotFoundException();
        }
        save(requestMeal, meal, date);
    }
    //받아온 파라미터들을 foreach안에서 toEntity로 엔티티화 시키고 DB에 저장
    private void save(RequestMealDto requestMeal, Meal meal, Date date) {
        requestMeal.getMenu().forEach(
                (k, v) -> {
                    dailyvoteRepository.save(toEntity(date, meal, k, v));
                    totalVoteRepository.save(toEntity(k,v));
                }
        );
    }
    // 매일 투표한 것을 엔티티화 시켜줍니다.
    // 같은 메뉴가 또 나와 투표가 될 수 있기 때문에 해당 메뉴에 원래 있던 투표수와 받아온 투표수를 더해서 set 해둠
    public DailyVote toEntity(Date date, Meal meal, String menu, int numOfVote){
        if(dailyvoteRepository.existsByMenuName(menu)) {
            DailyVote entity = dailyvoteRepository.getByMenuName(menu);
            numOfVote += entity.getNumOfValue();
            entity.setNumOfValue(numOfVote);
            return entity;
        }
        return DailyVote.builder()
                .meal(meal)
                .date(date)
                .menuName(menu)
                .numOfValue(numOfVote)
                .build();
    }
    // 매일 투표한 것들을 메뉴들을 엔티티화 하여 모아놓을 수 있도록 합니다.

    public TotalVote toEntity(String menu, int numOfVote){
        if(totalVoteRepository.existsByMenu(menu)){
            TotalVote entity = totalVoteRepository.getByMenu(menu);
            numOfVote += entity.getNumOfValue();
            entity.setNumOfValue(numOfVote);
            return entity;
        }
        return TotalVote.builder()
                .menu(menu)
                .numOfValue(numOfVote)
                .version("version")
                .build();
        // throw new NotFoundMenuName
    }

}
