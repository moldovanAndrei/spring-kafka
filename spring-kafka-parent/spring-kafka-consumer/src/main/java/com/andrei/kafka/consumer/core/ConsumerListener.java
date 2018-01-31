/*
 * spring-kafka-consumer:SimpleMessageConsumer.java
 */
package com.andrei.kafka.consumer.core;

import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;

/**
 * Class defining the kafka consumer listeners.
 *
 * @author Andrei Moldovan
 * @since 30.01.2018
 */
public class ConsumerListener {

	private CountDownLatch simpleLatch = new CountDownLatch(3);
	private CountDownLatch customLatch = new CountDownLatch(1);

	/**
	 * Kafka listener for the simple String messages.
	 * 
	 * @param message
	 *            the string message.
	 */
	@KafkaListener(topics = "${message.topic.name}", group = "message", containerFactory = "messageKafkaListenerContainerFactory")
	public void listenGroupSimple(String message) {
		System.out.println("Received message from simple: " + message);
		this.simpleLatch.countDown();
	}

	/**
	 * Kafka listener for the custom object message.
	 * 
	 * @param customMessage
	 *            the object message.
	 */
	@KafkaListener(topics = "${custom.topic.name}", group = "custom", containerFactory = "customKafkaListenerContainerFactory")
	public void listenGroupCustom(CustomMessage customMessage) {
		System.out.println("Received message from custom: " + customMessage);
		this.customLatch.countDown();
	}

	public CountDownLatch getSimpleLatch() {
		return this.simpleLatch;
	}

	public CountDownLatch getCustomLatch() {
		return this.customLatch;
	}
}
