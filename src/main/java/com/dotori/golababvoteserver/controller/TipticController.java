package com.dotori.golababvoteserver.controller;

import com.dotori.golababvoteserver.Service.TipticService;
import com.dotori.golababvoteserver.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
