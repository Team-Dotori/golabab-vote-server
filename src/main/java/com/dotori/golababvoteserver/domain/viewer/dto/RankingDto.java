package com.dotori.golababvoteserver.domain.viewer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RankingDto {
    /*
    최윤성 — 오늘 오후 5:17
data class Ranking(
    @SerializedName("menu_name")
    val menuName: String,
    @SerializedName("num_of_vote")
    val numOfVote: Int
)
     */
    private final String menuName;
    private final Integer numOfVote;
}
