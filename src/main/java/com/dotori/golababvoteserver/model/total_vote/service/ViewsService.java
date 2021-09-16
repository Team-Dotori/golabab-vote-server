package com.dotori.golababvoteserver.model.total_vote.service;

import com.dotori.golababvoteserver.model.total_vote.TotalVote;
import com.dotori.golababvoteserver.model.total_vote.repository.TotalVoteRepository;
import com.dotori.golababvoteserver.dto.ViewsDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ViewsService {
    private final TotalVoteRepository totalVoteRepository;

    public String returnViews(ViewsDto viewsDto){
        ObjectMapper mapper = new ObjectMapper();
        AtomicReference<String> json = new AtomicReference<>();
        /*
        // TotalVote 타입의 리스트를 선언하고
        이 엔티티에 Repository에서 version 값을 가진 컬럼들의 1위가 제일 높은 투표수를 가진 순으로 20위까지 정렬해서 반환해줌
         */
        List<TotalVote> entities = totalVoteRepository.findTop20ByVersionOrderByNumOfValueDesc("version");
        Map<String, Integer> map = entities.stream().collect(Collectors.toMap(TotalVote::getMenu, TotalVote::getNumOfValue));

        entities.forEach(entity -> {
            try {
                json.set(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map)); // Map 형식으로 되어 있는 값을 json 으로 변환하여 반환함
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return json.get();
    }
}
