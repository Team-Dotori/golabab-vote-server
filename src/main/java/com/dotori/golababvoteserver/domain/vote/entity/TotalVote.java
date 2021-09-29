package com.dotori.golababvoteserver.domain.vote.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@NoArgsConstructor
public class TotalVote {
    @Id @GeneratedValue
    Long idx;
    @Column
    String menu;
    @Column
    int numOfValue;
    @Column
    String version;

    @Builder
    public TotalVote(Long idx, String menu, int numOfValue) {
        this.idx = idx;
        this.menu = menu;
        this.numOfValue = numOfValue;
        this.version = "version";
    }
}

