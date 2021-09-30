package com.dotori.golababvoteserver.domain.viewer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MenuRankingRequestDto {
    int start;
    int end;
    String range;

    public MenuRankingRequestDto(int start, int end, String range) {
        this.start = start;
        this.end = end;
        this.range = range;
    }
}
