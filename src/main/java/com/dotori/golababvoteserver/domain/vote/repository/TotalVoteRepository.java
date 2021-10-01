package com.dotori.golababvoteserver.domain.vote.repository;

import com.dotori.golababvoteserver.domain.vote.entity.TotalVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TotalVoteRepository extends JpaRepository<TotalVote, Long> {
    boolean existsByMenu(String Menu);
    TotalVote getByMenu(String Menu);
    List<TotalVote> findAllByOrderByNumOfVoteDesc();
}
