package com.dotori.golababvoteserver.repository;

import com.dotori.golababvoteserver.model.TotalVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TotalVoteRepository extends JpaRepository<TotalVote, Long> {
    boolean existsByMenu(String Menu);
    TotalVote getByMenu(String Menu);
    List<TotalVote> findTop20ByVersionOrderByNumOfValueDesc(String Version);
}
