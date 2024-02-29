package com.message.handler.MessageHandler.controller;

import com.message.handler.MessageHandler.model.SentMessage;
import com.message.handler.MessageHandler.service.MessageSendingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/message-sender")
@AllArgsConstructor
public class MessageSendingController {

    private final MessageSendingService messageSendingService;

    @GetMapping("/sent-messages")
    public ResponseEntity<List<SentMessage>> getSentMessages() {
        List<SentMessage> sentMessages = messageSendingService.getSentMessages();
        return ResponseEntity.ok(sentMessages);
    }
}
