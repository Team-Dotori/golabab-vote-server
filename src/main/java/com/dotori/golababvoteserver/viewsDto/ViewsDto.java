package com.dotori.golababvoteserver.viewsDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ViewsDto { // Controller에서 request param 으로 들어온 요청을 담아주는 Dto 이걸 이용해서 랭킹을 반환할 것
    int start;
    int end;
    String range;

    public ViewsDto(int start, int end, String range) {
        this.start = start;
        this.end = end;
        this.range = range;
    }
}
