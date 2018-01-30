/*
 * spring-kafka-producer:CustomMessageProducer.java
 */
package com.andrei.kafka.producer.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Custom message producer implementation for seinding {@link CustomMessage}
 * messages.
 * 
 * @author Andrei Moldovan
 * @since 29.01.2018
 */
public class CustomMessageProducer {

	private static final Logger LOG = LoggerFactory.getLogger(CustomMessageProducer.class);

	@Autowired
	private KafkaTemplate<String, CustomMessage> kafkaTemplate;

	@Value(value = "${custom.topic.name}")
	private String topicName;

	public void sendMessage(CustomMessage message) {
		LOG.info("Sending message \"{}\"", message);
		this.kafkaTemplate.send(this.topicName, message);
	}
}
