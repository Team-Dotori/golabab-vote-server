package com.dotori.golababvoteserver.mealDto;

import com.dotori.golababvoteserver.mealService.MealService;
import com.dotori.golababvoteserver.model.Meal;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestDto {
    private final RequestMealDto breakfast;
    private final RequestMealDto lunch;
    private final RequestMealDto dinner;

    public void mealSave(MealService mealService){
        mealService.save(this, Meal.BREAKFAST);
        mealService.save(this, Meal.LUNCH);
    try{
        if(mealService.getDateDay() != 5) { // 금요일이면
            mealService.save(this, Meal.DINNER);
        }
    } catch(Exception e){}

    }
}

