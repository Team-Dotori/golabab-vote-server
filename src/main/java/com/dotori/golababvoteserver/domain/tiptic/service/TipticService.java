package com.dotori.golababvoteserver.domain.tiptic.service;

import com.dotori.golababvoteserver.domain.tiptic.entity.ImproveMessage;
import com.dotori.golababvoteserver.domain.tiptic.repository.TipticRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
                .stream().map(ImproveMessage::getMessage).collect(Collectors.toList());
        int numOfTiptics = tiptics.size(); //20
        return Stream.of(new int[7])
                .map(el -> tiptics.get(new Random().nextInt(numOfTiptics))).collect(Collectors.toList());
    }

    public Date before5Days(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,-5);
        date.setTime(cal.getTimeInMillis());
        return date;
    }
}
