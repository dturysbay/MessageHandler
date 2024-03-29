package com.message.handler.MessageHandler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class MessageHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessageHandlerApplication.class, args);
	}

}
