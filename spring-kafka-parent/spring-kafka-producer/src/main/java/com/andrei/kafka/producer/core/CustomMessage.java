/*
 * spring-kafka-producer:ProducerMessage.java
 */
package com.andrei.kafka.producer.core;

import java.time.LocalDateTime;

/**
 * Kafka producer message object.
 * 
 * @author Andrei Moldovan
 * @since 29.01.2018
 */
public class CustomMessage {

	private String message;
	private LocalDateTime timestamp;

	public CustomMessage(String message, LocalDateTime timestamp) {
		super();
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return this.message;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}
}
