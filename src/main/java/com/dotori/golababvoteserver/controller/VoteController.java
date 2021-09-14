package com.dotori.golababvoteserver.controller;

import com.dotori.golababvoteserver.mealDto.RequestDto;
import com.dotori.golababvoteserver.mealService.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
@Controller
public class VoteController {
    private final MealService mealService;

    @PostMapping("/collect-total-vote-at-day")
    public void voteSave(@RequestBody RequestDto requestDto) {
        requestDto.mealSave(mealService);
    }
}
