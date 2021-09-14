package com.dotori.golababvoteserver.repository;

import com.dotori.golababvoteserver.model.DailyVote;
import com.dotori.golababvoteserver.model.TotalVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyvoteRepository extends JpaRepository<DailyVote, Long> {
    boolean existsByMenuName(String menu);
    DailyVote getByMenuName(String menu);
}
