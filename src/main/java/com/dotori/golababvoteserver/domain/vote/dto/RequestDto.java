package com.dotori.golababvoteserver.domain.vote.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class RequestDto {
    private final RequestMealDto breakfast;
    private final RequestMealDto lunch;
    private final RequestMealDto dinner;

}

