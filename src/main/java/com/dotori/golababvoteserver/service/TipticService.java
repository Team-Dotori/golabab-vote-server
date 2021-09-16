package com.dotori.golababvoteserver.service;

import com.dotori.golababvoteserver.dto.MessageDto;
import com.dotori.golababvoteserver.model.ImproveMessage;
import com.dotori.golababvoteserver.repository.TipticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public List<String> GetMessage(){
        Date cd = new Date();
        Date bef5 = before5Days(cd);
        
        List<String> tiptics = tipticRepository.getImproveMessageByDateAfter(bef5);
        int numOfTiptics = tiptics.size(); //20
        int[] randomIdx = new int[7]; //5 랜덤 < numOfTiptics
        List<String> random5 = Arrays.asList(randomIdx).stream()
                .map(el -> tiptics.get(new Random().nextInt(numOfTiptics))).collect(Collectors.toList());
        return random5;
    }

    public Date before5Days(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,-5);
        date.setTime(cal.getTimeInMillis());
        return date;
    }


    public ImproveMessage toEntity(MessageDto messageDto, Date date){
        return ImproveMessage.builder()
                .message(messageDto.getMessage())
                .date(date)
                .build();
    }
}
