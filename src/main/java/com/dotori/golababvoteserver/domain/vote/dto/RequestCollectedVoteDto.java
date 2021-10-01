package com.dotori.golababvoteserver.domain.vote.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class RequestCollectedVoteDto {
    private RequestMealDto breakfast;
    private RequestMealDto lunch;
    private RequestMealDto dinner;

    public static void main(String[] args) throws JsonProcessingException {
        Map<String, Integer> breakfast = new HashMap<>();
        breakfast.put("소고기스프", 25);
        breakfast.put("길거리토스트", 64);
        breakfast.put("바나나", 1);
        breakfast.put("콘푸로스트/초코첵스 백색우유", 79);
        Map<String, Integer> lunch = new HashMap<>();
        lunch.put("찰보리밥", 2);
        lunch.put("시레기된장국", 3);
        lunch.put("돼지고기편육보쌈김치", 172);
        lunch.put("오이스틱고추쌈장", 0);
        lunch.put("어묵간장볶음", 21);
        lunch.put("파인애플", 17);
        Map<String, Integer> dinner = new HashMap<>();
        dinner.put("백미밥", 0);
        dinner.put("설렁탕/소면", 32);
        dinner.put("돼지고기김치볶음", 48);
        dinner.put("진멸치땅콩볶음", 3);
        dinner.put("핫치킨브리또", 54);
        dinner.put("깍두기", 1);

        RequestMealDto breakfastMeal = new RequestMealDto(breakfast);
        RequestMealDto lunchMeal = new RequestMealDto(lunch);
        RequestMealDto dinnerMeal = new RequestMealDto(dinner);

        RequestCollectedVoteDto requestCollectedVote = new RequestCollectedVoteDto(breakfastMeal, lunchMeal, dinnerMeal);

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(requestCollectedVote));
    }
}

