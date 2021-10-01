package com.dotori.golababvoteserver.domain.vote.service;

import com.dotori.golababvoteserver.domain.vote.dto.RequestCollectedVoteDto;
import com.dotori.golababvoteserver.domain.vote.dto.RequestMealDto;
import com.dotori.golababvoteserver.domain.vote.entity.DailyVote;
import com.dotori.golababvoteserver.domain.vote.enum_type.MealType;
import com.dotori.golababvoteserver.domain.vote.entity.TotalVote;
import com.dotori.golababvoteserver.domain.vote.repository.DailyVoteRepository;
import com.dotori.golababvoteserver.domain.vote.repository.TotalVoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MealServiceImpl implements MealService{
    private final TotalVoteRepository totalVoteRepository;
    private final DailyVoteRepository dailyvoteRepository;

    private int getDateDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now());
        return calendar.get(Calendar.DAY_OF_WEEK); //1=SUN, 2=MON...7=SAT
    }
    private Date now() {
        return new Date();
    }
    private boolean isFriday() {
        return getDateDay() == 6;
    }

    @Transactional
    public void collectAll(@NotNull RequestCollectedVoteDto requestCollectedVoteDto) {
        Date now = now();//시스템 성능으로인한 date 의 차이를 방지한다

        collect(requestCollectedVoteDto.getBreakfast(), MealType.BREAKFAST, now);
        collect(requestCollectedVoteDto.getLunch(), MealType.LUNCH, now);
        if(!isFriday())//if today isn't friday
            collect(requestCollectedVoteDto.getDinner(), MealType.DINNER, now);
    }
    private void collect(RequestMealDto meal, MealType mealType, Date now) {
        meal.getMenus().forEach(
                (menuName, numOfVote) -> {
                    collectAtDaily(now, mealType, menuName, numOfVote);
                    collectAtTotal(menuName, numOfVote);
                }
        );
    }
    private void collectAtTotal(String menuName, Integer numOfVote) {
        totalVoteRepository.save(toEntity(menuName,numOfVote));
    }
    private void collectAtDaily(Date date, MealType mealType, String menuName, Integer numOfVote) {
        dailyvoteRepository.save(toEntity(date, mealType, menuName, numOfVote));
    }

    //TODO 지인호 | create Converter | 2021.09.29
    private DailyVote toEntity(Date date, MealType mealType, String menu, int numOfVote){
        if(dailyvoteRepository.existsByMenuName(menu)) {
            DailyVote entity = dailyvoteRepository.getByMenuName(menu);
            numOfVote += entity.getNumOfValue();
            entity.setNumOfValue(numOfVote);
            return entity;
        }
        return DailyVote.builder()
                .mealType(mealType)
                .date(date)
                .menuName(menu)
                .numOfValue(numOfVote)
                .build();
    }
    //TODO 지인호 | create Converter | 2021.09.29
    private TotalVote toEntity(String menu, int numOfVote){
        if(totalVoteRepository.existsByMenu(menu)){
            TotalVote entity = totalVoteRepository.getByMenu(menu);
            numOfVote += entity.getNumOfVote();
            entity.setNumOfVote(numOfVote);
            return entity;
        }
        return TotalVote.builder()
                .menu(menu)
                .numOfVote(numOfVote)
                .build();
    }

}
