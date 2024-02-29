package com.message.handler.MessageHandler.service;

import com.message.handler.MessageHandler.model.Message;
import com.message.handler.MessageHandler.model.SentMessage;
import com.message.handler.MessageHandler.repository.SentMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessageSendingService {
    private final EmailSenderService emailSenderService;
    private final SentMessageRepository sentMessageRepository;

    @KafkaListener(topics = "message.send", groupId = "message-sender-group")
    public void processMessage(Message message) {

        try {
            emailSenderService.sendEmail(message.getSender(), message.getMessage());
            SentMessage sentMessage = new SentMessage(message.getSender(), message.getMessage(), 200);
            sentMessageRepository.save(sentMessage);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<SentMessage> getSentMessages() {
        return sentMessageRepository.findAll();
    }
}
