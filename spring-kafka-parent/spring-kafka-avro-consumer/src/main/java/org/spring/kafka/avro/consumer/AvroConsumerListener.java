package org.spring.kafka.avro.consumer;

import java.util.concurrent.CountDownLatch;

import javax.sound.midi.Receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.kafka.datagenerator.data.avro.AvroEvent;
import org.springframework.kafka.annotation.KafkaListener;

/**
 * Simple kafka consumer listener implementation.
 *
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
public class AvroConsumerListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

	private CountDownLatch latch = new CountDownLatch(1);

	public CountDownLatch getLatch() {
		return this.latch;
	}

	/**
	 * Consumes {@link AvroEvent} data from the specific topic and consumer
	 * group.
	 *
	 * @param event
	 *            the {@link AvroEvent} object from Kafka.
	 */
	@KafkaListener(topics = "${kafka.topic.avro}", groupId = "${consumer.group.id}", containerFactory = "kafkaListenerContainerFactory")
	public void consume(final AvroEvent event) {
		LOGGER.info("received event='{}'", event.toString());
		this.latch.countDown();
	}
}
