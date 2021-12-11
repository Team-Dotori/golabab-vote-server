package com.dotori.golababvoteserver.domain.vote.dto;


import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestMealDto {
    private Map<String, Integer> menus;
}
