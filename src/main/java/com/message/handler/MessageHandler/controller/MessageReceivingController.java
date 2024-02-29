package com.message.handler.MessageHandler.controller;

import com.message.handler.MessageHandler.model.Message;
import com.message.handler.MessageHandler.service.MessageReceivingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;
import java.util.List;

@Controller
@RequestMapping("/messages")
@AllArgsConstructor
public class MessageReceivingController {
    private final MessageReceivingService messageReceivingService;


    @PostMapping(consumes = "application/xml")
    public ResponseEntity<String> receiveMessage(@RequestBody Message message) {
        try {
            messageReceivingService.receiveAndSend(message);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Message received and sent for processing");
        } catch (JAXBException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid XML format");
        }
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessages(@RequestParam(required = false) String user) {
        List<Message> messages = messageReceivingService.getMessages(user);
        return ResponseEntity.ok(messages);
    }

}
