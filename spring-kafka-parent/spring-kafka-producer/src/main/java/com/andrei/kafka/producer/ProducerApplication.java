/*
 * spring-kafka-producer:ProducerApplication.java
 */
package com.andrei.kafka.producer;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.andrei.kafka.producer.core.CustomMessage;
import com.andrei.kafka.producer.core.CustomMessageProducer;
import com.andrei.kafka.producer.core.SimpleMessageProducer;

/**
 * Spring Boot App for the kafka consumer.
 *
 * @author Andrei Moldovan
 * @since 29.01.2018
 */
@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProducerApplication.class);
		SimpleMessageProducer simpleMessageProducer = context.getBean(SimpleMessageProducer.class);
		CustomMessageProducer customMessageProducer = context.getBean(CustomMessageProducer.class);

		Scanner scanner = new Scanner(System.in);
		while (true) {
			String message = scanner.nextLine();
			simpleMessageProducer.sendMessage(message);
			customMessageProducer.sendMessage(new CustomMessage(message, LocalDateTime.now()));
		}
	}
}
