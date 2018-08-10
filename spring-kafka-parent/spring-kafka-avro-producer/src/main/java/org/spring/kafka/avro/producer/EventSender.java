package org.spring.kafka.avro.producer;

import org.spring.kafka.avro.producer.data.EventData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Sends the {@link EventData} to the kafka broker.
 *
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
public class EventSender {

	private KafkaTemplate<String, byte[]> kafkaTemplate;

	@Value(value = "${kafka.topic.avro}")
	private String topic;

	@Autowired
	public EventSender(final KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void send(final EventData eventData) {
		this.kafkaTemplate.send(this.topic, eventData.getEventType(), eventData.getData());
	}
}
