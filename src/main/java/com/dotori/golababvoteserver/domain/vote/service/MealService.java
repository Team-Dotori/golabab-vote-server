package com.dotori.golababvoteserver.domain.vote.service;

import com.dotori.golababvoteserver.domain.vote.dto.RequestCollectedVoteDto;

import javax.validation.constraints.NotNull;

public interface MealService {
    void collectAll(@NotNull RequestCollectedVoteDto requestCollectedVoteDto);
}
