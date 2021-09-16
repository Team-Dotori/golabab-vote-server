package com.dotori.golababvoteserver.model.daily_vote.repository;

import com.dotori.golababvoteserver.model.daily_vote.DailyVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyvoteRepository extends JpaRepository<DailyVote, Long> {
    boolean existsByMenuName(String menu);
    DailyVote getByMenuName(String menu);
}
