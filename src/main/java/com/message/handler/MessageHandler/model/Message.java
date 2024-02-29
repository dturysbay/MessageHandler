package com.message.handler.MessageHandler.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Message{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String sender;
    private String message;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    @JsonCreator
    public Message(@JsonProperty("sender") String sender, @JsonProperty("message") String message) {
        this.sender = sender;
        this.message = message;
    }
}
