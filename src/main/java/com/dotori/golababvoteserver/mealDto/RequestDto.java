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

}

