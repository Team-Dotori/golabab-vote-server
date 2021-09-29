package com.dotori.golababvoteserver.domain.viewer.controller;


import com.dotori.golababvoteserver.domain.viewer.dto.ResponseRankingDto;
import com.dotori.golababvoteserver.domain.viewer.service.ViewsService;
import com.dotori.golababvoteserver.domain.viewer.dto.ViewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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