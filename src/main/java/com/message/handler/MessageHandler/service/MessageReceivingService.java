package com.message.handler.MessageHandler.service;

import com.message.handler.MessageHandler.model.Message;
import com.message.handler.MessageHandler.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageReceivingService {
    private final KafkaTemplate<String, Message> kafkaTemplate;
    private final MessageRepository messageRepository;

    public void receiveAndSend(Message message) throws JAXBException {
        kafkaTemplate.send("message.send", message);
        messageRepository.save(message);
    }

    public List<Message> getMessages(String user) {
        if (user != null) {
            return messageRepository.findBySender(user);
        } else {
            return messageRepository.findTop10ByOrderByTimestampDesc();
        }
    }
}
