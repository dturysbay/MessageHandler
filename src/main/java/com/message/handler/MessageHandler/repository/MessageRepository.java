package com.message.handler.MessageHandler.repository;

import com.message.handler.MessageHandler.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySender(String sender);

    List<Message> findTop10ByOrderByTimestampDesc();
}
