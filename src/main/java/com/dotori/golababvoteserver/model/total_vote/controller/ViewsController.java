package com.dotori.golababvoteserver.model.total_vote.controller;


import com.dotori.golababvoteserver.dto.ResponseRankingDto;
import com.dotori.golababvoteserver.model.total_vote.dto.RankingDto;
import com.dotori.golababvoteserver.model.total_vote.service.ViewsService;
import com.dotori.golababvoteserver.dto.ViewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1/views")
@RestController
public class ViewsController {
    private final ViewsService viewsService;

    @ResponseBody
    @GetMapping("/menu-ranking")
    public ResponseRankingDto Ranking(@RequestParam int start, int end, String range ){
        ViewsDto viewsDto = new ViewsDto(start, end, range);
        return new ResponseRankingDto(viewsService.returnViews(viewsDto));
    }

}
