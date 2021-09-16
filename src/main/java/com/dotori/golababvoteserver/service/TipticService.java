package com.dotori.golababvoteserver.service;

import com.dotori.golababvoteserver.dto.MessageDto;
import com.dotori.golababvoteserver.model.ImproveMessage;
import com.dotori.golababvoteserver.repository.TipticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class TipticService {
    private final TipticRepository tipticRepository;

    public void MessageSave(MessageDto messageDto){
        if (messageDto != null ){
            throw new NullPointerException();
        }
        Date date = new Date();
        tipticRepository.save(toEntity(messageDto,date));
    }

    public String GetMessage(){

    }

    public ImproveMessage toEntity(MessageDto messageDto, Date date){
        return ImproveMessage.builder()
                .message(messageDto.getMessage())
                .date(date)
                .build();
    }
}
