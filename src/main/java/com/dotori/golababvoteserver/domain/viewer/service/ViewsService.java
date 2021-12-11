package com.dotori.golababvoteserver.domain.viewer.service;

import com.dotori.golababvoteserver.domain.viewer.converter.RankingDtoConverter;
import com.dotori.golababvoteserver.domain.vote.entity.TotalVote;
import com.dotori.golababvoteserver.domain.viewer.dto.RankingDto;
import com.dotori.golababvoteserver.domain.vote.repository.TotalVoteRepository;
import com.dotori.golababvoteserver.domain.viewer.dto.MenuRankingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ViewsService {
    private final TotalVoteRepository totalVoteRepository;

    public List<RankingDto> getRankingByViews(MenuRankingRequestDto menuRankingRequestDto) {
        List<TotalVote> entities = totalVoteRepository.findAllByOrderByNumOfVoteDesc();
        List<RankingDto> votes = entities.stream()
                .map(RankingDtoConverter::toRankingDto)
                .collect(Collectors.toList());
        return votes.subList(menuRankingRequestDto.getStart(), menuRankingRequestDto.getEnd());
    }
}
