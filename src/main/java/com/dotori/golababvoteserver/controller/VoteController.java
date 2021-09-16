package com.dotori.golababvoteserver.controller;

import com.dotori.golababvoteserver.dto.RequestDto;
import com.dotori.golababvoteserver.service.MealService;
import com.dotori.golababvoteserver.model.Meal;
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
