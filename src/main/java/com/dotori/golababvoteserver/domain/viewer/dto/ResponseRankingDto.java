package com.dotori.golababvoteserver.domain.viewer.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Getter
public class ResponseRankingDto {
    private final List<RankingDto> list;
}
