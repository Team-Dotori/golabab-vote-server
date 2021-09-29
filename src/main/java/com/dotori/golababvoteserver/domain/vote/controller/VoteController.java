package com.dotori.golababvoteserver.domain.vote.controller;

import com.dotori.golababvoteserver.domain.vote.dto.RequestDto;
import com.dotori.golababvoteserver.domain.vote.service.MealService;
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
    public void voteSave(@RequestBody RequestDto requestDto) {
        mealService.collectAll(requestDto);
    }
}
