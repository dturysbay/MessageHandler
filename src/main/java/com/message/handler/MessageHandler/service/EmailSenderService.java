package com.message.handler.MessageHandler.service;

import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    public void sendEmail(String recipient, String message) {
        System.out.println("Sending email to: " + recipient);
        System.out.println("Message: " + message);
    }
}
