package com.dotori.golababvoteserver.domain.viewer.service;

import com.dotori.golababvoteserver.domain.viewer.converter.RankingDtoConverter;
import com.dotori.golababvoteserver.domain.vote.entity.TotalVote;
import com.dotori.golababvoteserver.domain.viewer.dto.RankingDto;
import com.dotori.golababvoteserver.domain.vote.repository.TotalVoteRepository;
import com.dotori.golababvoteserver.domain.viewer.dto.ViewsDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ViewsService {
    private final TotalVoteRepository totalVoteRepository;

    public List<RankingDto> returnViews(ViewsDto viewsDto){
        ObjectMapper mapper = new ObjectMapper();
        AtomicReference<String> json = new AtomicReference<>();
        /*
        // TotalVote 타입의 리스트를 선언하고
        이 엔티티에 Repository에서 version 값을 가진 컬럼들의 1위가 제일 높은 투표수를 가진 순으로 20위까지 정렬해서 반환해줌
         */
        List<TotalVote> entities = totalVoteRepository.findTop20ByVersionOrderByNumOfValueDesc("version");
        List<RankingDto> returnValue = entities.stream()
                .map(RankingDtoConverter::toRankingDto)
                .collect(Collectors.toList());
        entities.forEach(entity -> {
            try {
                json.set(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(returnValue)); // Map 형식으로 되어 있는 값을 json 으로 변환하여 반환함
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return returnValue;
    }
}
