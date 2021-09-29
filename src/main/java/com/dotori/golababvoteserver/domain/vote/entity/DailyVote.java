package com.dotori.golababvoteserver.domain.vote.entity;

import com.dotori.golababvoteserver.domain.vote.enum_type.MealType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "daily_vote") @Getter @Setter
@NoArgsConstructor
public class DailyVote {
    @Id @GeneratedValue
    @Column(name = "idx")
    private Long idx;
    @Column(name = "Daily_Date")
    private Date date;
    @Column(name = "daily_meal" , columnDefinition = "ENUM('BREAKFAST', 'LUNCH', 'DINNER')")
    @Enumerated(EnumType.STRING)
    private MealType mealType;
    @Column
    private String menuName;
    @Column
    private int numOfValue;

    @Builder
    public DailyVote(Long idx, Date date, MealType mealType, String menuName, int numOfValue) {
        this.idx = idx;
        this.date = date;
        this.mealType = mealType;
        this.menuName = menuName;
        this.numOfValue = numOfValue;
    }
}