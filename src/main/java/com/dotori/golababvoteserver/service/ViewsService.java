package com.dotori.golababvoteserver.service;

import com.dotori.golababvoteserver.model.TotalVote;
import com.dotori.golababvoteserver.repository.TotalVoteRepository;
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
        List<TotalVote> entities = totalVoteRepository.findTop20ByVersionOrderByNumOfValueDesc("version");
        Map<String, Integer> map = entities.stream().collect(Collectors.toMap(TotalVote::getMenu, TotalVote::getNumOfValue));

        entities.forEach(entity -> {
            try {
                json.set(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        return json.get();
    }
}
