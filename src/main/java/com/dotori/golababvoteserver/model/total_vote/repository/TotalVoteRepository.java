package com.dotori.golababvoteserver.model.total_vote.repository;

import com.dotori.golababvoteserver.model.total_vote.TotalVote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TotalVoteRepository extends JpaRepository<TotalVote, Long> {
    boolean existsByMenu(String Menu);
    TotalVote getByMenu(String Menu);
    List<TotalVote> findTop20ByVersionOrderByNumOfValueDesc(String Version); // version의 값이 같은 값들을 모두 불러와 20위까지 정렬하여 반환해줌
}
