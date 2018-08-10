package com.andrei.kafka.consumer.core;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Kafka producer message object.
 * 
 * @author Andrei Moldovan
 * @since 30.01.2018
 */
public class CustomMessage {

	private String message;
	private LocalDateTime timestamp;

	public CustomMessage() {
	}

	@JsonCreator
	public CustomMessage(@JsonProperty("message") String message, @JsonProperty("timestamp") LocalDateTime timestamp) {
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return this.message;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

	@Override
	public String toString() {
		return "[" + this.timestamp + ": " + this.message + "]";
	}
}
