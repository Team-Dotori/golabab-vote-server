package com.dotori.golababvoteserver.repository;

import com.dotori.golababvoteserver.model.ImproveMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipticRepository extends JpaRepository<ImproveMessage,Long> {

}
