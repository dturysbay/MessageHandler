package com.message.handler.MessageHandler.repository;

import com.message.handler.MessageHandler.model.SentMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentMessageRepository extends JpaRepository<SentMessage, Long> {
}
