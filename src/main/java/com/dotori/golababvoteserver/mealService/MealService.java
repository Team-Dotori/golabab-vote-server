package com.dotori.golababvoteserver.mealService;

import com.dotori.golababvoteserver.advie.MealNotFoundException;
import com.dotori.golababvoteserver.mealDto.RequestDto;
import com.dotori.golababvoteserver.mealDto.RequestMealDto;
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

    private void save(RequestMealDto requestMeal, Meal meal, Date date) {

        requestMeal.getMenu().forEach(
                (k, v) -> {
                    dailyvoteRepository.save(toEntity(date, meal, k, v));
                    totalVoteRepository.save(toEntity(k,v));
                }
        );
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
                .NumOfValue(numOfVote)
                .build();
        // throw new NotFoundMenuName
        }
}
