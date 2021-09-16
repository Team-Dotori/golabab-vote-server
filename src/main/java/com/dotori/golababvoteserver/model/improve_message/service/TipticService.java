package com.dotori.golababvoteserver.model.improve_message.service;

import com.dotori.golababvoteserver.model.improve_message.ImproveMessage;
import com.dotori.golababvoteserver.model.improve_message.repository.TipticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TipticService {
    private final TipticRepository tipticRepository;

    public void MessageSave(String message){
        Date date = new Date();
        tipticRepository.save(new ImproveMessage(message,date));
    }

    public List<String> GetMessage(){
        Date cd = new Date();
        Date bef5 = before5Days(cd);
        
        List<String> tiptics = tipticRepository.getImproveMessageByDateAfter(bef5)
                .stream().map(improveMessage -> improveMessage.getMessage()).collect(Collectors.toList());
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
}
