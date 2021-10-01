package com.dotori.golababvoteserver.domain.tiptic.repository;

import com.dotori.golababvoteserver.domain.tiptic.entity.ImproveMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TipticRepository extends JpaRepository<ImproveMessage,Long> {
    List<ImproveMessage> getImproveMessageByDateAfter(Date date);
}
