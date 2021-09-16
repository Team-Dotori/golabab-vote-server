package com.dotori.golababvoteserver.controller;

import com.dotori.golababvoteserver.service.TipticService;
import com.dotori.golababvoteserver.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tiptic")
public class TipticController {
    private final TipticService tipticService;

    @PostMapping("/add-improve-message")                              //추후 상세 Exception으로 변경
    public void improveMessageSave(@RequestBody MessageDto messageDto) throws Exception {
        tipticService.MessageSave(messageDto);
    }

    @GetMapping("/get-improve-message")                               //추후 상세 Exception으로 변경
    public List<String> getImproveMessage() throws Exception{
        return tipticService.GetMessage();
    }

}
