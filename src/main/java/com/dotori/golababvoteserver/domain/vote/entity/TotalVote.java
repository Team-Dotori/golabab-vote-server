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
    int numOfVote;
    @Column
    String version;

    @Builder
    public TotalVote(Long idx, String menu, int numOfVote) {
        this.idx = idx;
        this.menu = menu;
        this.numOfVote = numOfVote;
        this.version = "version";
    }
}

