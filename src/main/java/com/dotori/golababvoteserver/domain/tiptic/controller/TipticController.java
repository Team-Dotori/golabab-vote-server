package com.dotori.golababvoteserver.domain.tiptic.controller;

import com.dotori.golababvoteserver.domain.tiptic.service.TipticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tiptic")
public class    TipticController {
    private final TipticService tipticService;

    @GetMapping("/add-improve-message")                              //추후 상세 Exception으로 변경
    public void improveMessageSave(@RequestParam String message) {
        tipticService.MessageSave(message);
    }

    @GetMapping("/get-improve-message")                               //추후 상세 Exception으로 변경
    public List<String> getImproveMessage() {
        return tipticService.GetMessage();
    }

}
