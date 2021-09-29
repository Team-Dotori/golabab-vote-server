package com.dotori.golababvoteserver.domain.vote.repository;

import com.dotori.golababvoteserver.domain.vote.entity.DailyVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyvoteRepository extends JpaRepository<DailyVote, Long> {
    boolean existsByMenuName(String menu);
    DailyVote getByMenuName(String menu);
}
