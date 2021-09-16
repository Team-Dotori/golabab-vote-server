package com.dotori.golababvoteserver.model.total_vote.controller;


import com.dotori.golababvoteserver.model.total_vote.service.ViewsService;
import com.dotori.golababvoteserver.dto.ViewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/views")
@RestController
@Controller
public class ViewsController {
    private final ViewsService viewsService;

    @ResponseBody
    @GetMapping("/menu-ranking")
    public String Ranking(@RequestParam int start, int end, String range ){
        ViewsDto viewsDto = new ViewsDto(start, end, range);
        return viewsService.returnViews(viewsDto);
    }

}
