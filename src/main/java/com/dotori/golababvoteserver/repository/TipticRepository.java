package com.dotori.golababvoteserver.repository;

import com.dotori.golababvoteserver.model.ImproveMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TipticRepository extends JpaRepository<ImproveMessage,Long> {
    List<String> getImproveMessageByDateAfter(Date date);
}
