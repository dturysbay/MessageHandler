package com.message.handler.MessageHandler.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.sql.Timestamp;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
public class SentMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;
    private String message;
    private int responseCode;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public SentMessage(String sender, String message, Integer responseCode) {
        this.sender = sender;
        this.message = message;
        this.responseCode = responseCode;
    }
}
