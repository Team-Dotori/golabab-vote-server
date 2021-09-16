package com.dotori.golababvoteserver.model.daily_vote;

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
    private Meal meal;

    @Column
    private String menuName;

    @Column
    private int numOfValue;

    @Builder
    public DailyVote(Long idx, Date date, Meal meal, String menuName, int numOfValue) {
        this.idx = idx;
        this.date = date;
        this.meal = meal;
        this.menuName = menuName;
        this.numOfValue = numOfValue;
    }
}

/*
@ElementCollection:

연관된 부모 Entity 하나에만 연관되어 관리된다. (부모 Entity와 독립적으로 사용 X)
항상 부모와 함께 저장되고 삭제되므로 cascade 옵션은 제공하지 않는다. (cascade = ALL 인 셈)
부모 Entity Id와 추가 컬럼(basic or embedded 타입)으로 구성된다.
기본적으로 식별자 개념이 없으므로 컬렉션 값 변경 시, 전체 삭제 후 새로 추가한다.


 */