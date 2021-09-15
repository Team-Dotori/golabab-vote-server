package com.dotori.golababvoteserver.model;

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
    Long Idx;

    @Column
    String menu;

    @Column
    int numOfValue;

    @Column
    String version;

    @Builder
    public TotalVote(Long idx, String menu, int numOfValue, String version) {
        Idx = idx;
        this.menu = menu;
        this.numOfValue = numOfValue;
        this.version = version;
    }
}
