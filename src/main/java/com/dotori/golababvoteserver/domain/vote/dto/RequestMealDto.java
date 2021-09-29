package com.dotori.golababvoteserver.domain.vote.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

@Getter
@RequiredArgsConstructor
public class RequestMealDto {
    private final HashMap<String, Integer> menus;
}
