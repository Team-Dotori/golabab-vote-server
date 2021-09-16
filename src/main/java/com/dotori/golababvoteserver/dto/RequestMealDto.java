package com.dotori.golababvoteserver.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;

@Getter
@RequiredArgsConstructor
public class RequestMealDto {
    private final HashMap<String, Integer> menu;// hashmap에 잇는 string값과 integer값을 toEntity할 때 menu와 vote_num에 입력하여 엔티티화시킨다.
    public RequestMealDto() {
        menu = new HashMap<>();
    }
}
