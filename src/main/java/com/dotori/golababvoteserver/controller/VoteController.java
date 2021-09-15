package com.dotori.golababvoteserver.controller;

import com.dotori.golababvoteserver.mealDto.RequestDto;
import com.dotori.golababvoteserver.mealService.MealService;
import com.dotori.golababvoteserver.model.Meal;
import com.dotori.golababvoteserver.response.SingleResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/vote")
@Controller
public class VoteController {
    private final MealService mealService;

    @PostMapping("/collect-total-vote-at-day")
    public void voteSave(@RequestBody RequestDto requestDto) throws Exception {
        mealService.saveAll(requestDto, Meal.BREAKFAST, Meal.LUNCH, Meal.DINNER);
    }


}
