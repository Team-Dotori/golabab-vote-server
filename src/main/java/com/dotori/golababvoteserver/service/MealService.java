package com.dotori.golababvoteserver.service;

import com.dotori.golababvoteserver.exception.MealNotFoundException;
import com.dotori.golababvoteserver.dto.RequestDto;
import com.dotori.golababvoteserver.dto.RequestMealDto;
import com.dotori.golababvoteserver.model.DailyVote;
import com.dotori.golababvoteserver.model.Meal;
import com.dotori.golababvoteserver.model.TotalVote;
import com.dotori.golababvoteserver.repository.DailyvoteRepository;
import com.dotori.golababvoteserver.repository.TotalVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class MealService {
    private final DailyvoteRepository dailyvoteRepository;
    private final TotalVoteRepository totalVoteRepository;


    public int getDateDay() throws Exception {
        LocalDate date = LocalDate.now();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayOfWeek.getValue();

        return dayOfWeekNumber;
    }
    public void saveAll(RequestDto requestDto, Meal breakfast, Meal lunch, Meal dinner) throws Exception {
        save(requestDto, breakfast);
        save(requestDto, lunch);
        save(requestDto, dinner);
    }
    public RequestDto save(RequestDto requestDto, Meal meal) throws Exception {
        Date date = new Date();
        RequestMealDto requestMeal = null;
        switch (meal) {
            case BREAKFAST:
                requestMeal = requestDto.getBreakfast();
                break;
            case LUNCH:
                requestMeal = requestDto.getLunch();
                break;
            case DINNER:
                if(getDateDay() != 5)
                requestMeal = requestDto.getDinner();
                break;
            default:
                throw new MealNotFoundException();
        }
        save(requestMeal, meal, date);
        return requestDto;
    }
    private RequestMealDto save(RequestMealDto requestMeal, Meal meal, Date date) {

        requestMeal.getMenu().forEach(
                (k, v) -> {
                    dailyvoteRepository.save(toEntity(date, meal, k, v));
                    totalVoteRepository.save(toEntity(k,v));
                }
        );
        return requestMeal;
    }

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
