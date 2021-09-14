package com.dotori.golababvoteserver.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
@Entity
@NoArgsConstructor
public class TotalVote {
    @Id @GeneratedValue
    Long idx;

    @Column
    String menu;

    @Column
    int NumOfValue;

    @Builder
    public TotalVote(Long idx, String menu, int NumOfValue) {
        this.idx = idx;
        this.menu = menu;
        this.NumOfValue = NumOfValue;
    }
}
