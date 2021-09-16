package com.dotori.golababvoteserver.model.improve_message.repository;

import com.dotori.golababvoteserver.model.improve_message.ImproveMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TipticRepository extends JpaRepository<ImproveMessage,Long> {
    List<ImproveMessage> getImproveMessageByDateAfter(Date date);
}
