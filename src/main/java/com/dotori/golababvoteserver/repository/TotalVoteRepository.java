package com.dotori.golababvoteserver.repository;

import com.dotori.golababvoteserver.model.TotalVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TotalVoteRepository extends JpaRepository<TotalVote, Long> {
    boolean existsByMenu(String menu);
    TotalVote getByMenu(String menu);
}
