package com.dotori.golababvoteserver.controller;


import com.dotori.golababvoteserver.mealService.ViewsService;
import com.dotori.golababvoteserver.viewsDto.ViewsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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
