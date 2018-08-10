package org.spring.kafka.avro.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.spring.kafka.avro.consumer.AvroConsumerListener;
import org.spring.kafka.datagenerator.data.avro.AvroEvent;
import org.spring.kafka.datagenerator.data.avro.serialization.EventAvroDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

/**
 * Kafka consumer configuration class.
 *
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
@EnableKafka
@Configuration
public class AvroConsumerConfiguration {

	@Value(value = "${kafka.bootstrapServers}")
	private String bootstrapServers;
	@Value(value = "${kafka.topic.avro}")
	private String topic;
	@Value(value = "${consumer.group.id}")
	private String consumerGroupId;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, AvroEvent> kafkaListenerContainerFactory() {
		Map<String, Object> properties = new HashMap<>();
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, this.consumerGroupId);
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, EventAvroDeserializer.class);
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapServers);
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		DefaultKafkaConsumerFactory<String, AvroEvent> consumerFactory = new DefaultKafkaConsumerFactory<>(properties);
		ConcurrentKafkaListenerContainerFactory<String, AvroEvent> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		listenerContainerFactory.setConsumerFactory(consumerFactory);

		return listenerContainerFactory;
	}

	@Bean
	public AvroConsumerListener consumerListener() {
		return new AvroConsumerListener();
	}
}
