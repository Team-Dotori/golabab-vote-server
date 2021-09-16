package com.dotori.golababvoteserver.model.total_vote;

import com.dotori.golababvoteserver.model.total_vote.dto.RankingDto;

public class RankingDtoConverter {
    public static RankingDto toRankingDto(TotalVote totalVote) {
        return new RankingDto(totalVote.getMenu(), totalVote.getNumOfValue());
    }
}
