package com.dotori.golababvoteserver.domain.viewer.converter;

import com.dotori.golababvoteserver.domain.viewer.dto.RankingDto;
import com.dotori.golababvoteserver.domain.vote.entity.TotalVote;

public class RankingDtoConverter {
    public static RankingDto toRankingDto(TotalVote totalVote) {
        return new RankingDto(totalVote.getMenu(), totalVote.getNumOfVote());
    }
}
