/*
 * spring-kafka-producer:MessageProducer.java
 */
package com.andrei.kafka.producer.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Message producer implementation for seinding {@link String} messages.
 * 
 * @author Andrei Moldovan
 * @since 29.01.2018
 */
public class SimpleMessageProducer {

	private static final Logger LOG = LoggerFactory.getLogger(SimpleMessageProducer.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value(value = "${message.topic.name}")
	private String topicName;

	public void sendMessage(String message) {
		LOG.info("Sending message \"{}\"", message);
		this.kafkaTemplate.send(this.topicName, message);
	}
}
