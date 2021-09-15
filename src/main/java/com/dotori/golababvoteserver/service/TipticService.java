package com.dotori.golababvoteserver.service;

import com.dotori.golababvoteserver.dto.MessageDto;
import com.dotori.golababvoteserver.model.ImproveMessage;
import com.dotori.golababvoteserver.repository.TipticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class TipticService {
    private final TipticRepository tipticRepository;

    public void MessageSave(MessageDto messageDto){
        if (messageDto != null ){
            throw new NullPointerException();
        }
        LocalDate date = LocalDate.now();
        tipticRepository.save(toEntity(messageDto,date));
    }

    public ImproveMessage toEntity(MessageDto messageDto, LocalDate date){
        return ImproveMessage.builder()
                .message(messageDto.getMessage())
                .date(date)
                .build();
    }
}
