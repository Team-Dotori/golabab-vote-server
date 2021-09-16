package com.dotori.golababvoteserver.dto;

import com.dotori.golababvoteserver.model.total_vote.dto.RankingDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class ResponseRankingDto {
    private final List<RankingDto> list;
}
