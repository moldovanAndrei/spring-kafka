package com.andrei.kafka.consumer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.andrei.kafka.consumer.core.ConsumerListener;
import com.andrei.kafka.consumer.core.CustomMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Kafka consumer configuration class.
 * 
 * @author Andrei Moldovan
 * @since 30.01.2018
 */
@EnableKafka
@Configuration
public class ConsumerConfiguration {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> messageKafkaListenerContainerFactory() {
		Map<String, Object> properties = new HashMap<>();
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "simple");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);

		DefaultKafkaConsumerFactory<String, String> consumerFactory = new DefaultKafkaConsumerFactory<>(properties);
		ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		listenerContainerFactory.setConsumerFactory(consumerFactory);

		return listenerContainerFactory;
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, CustomMessage> customKafkaListenerContainerFactory() {
		Map<String, Object> properties = new HashMap<>();
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "custom");
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);

		DefaultKafkaConsumerFactory<String, CustomMessage> consumerFactory = new DefaultKafkaConsumerFactory<>(
				properties);
		// Override object mapper to include the java time module.
		consumerFactory.setValueDeserializer(new JsonDeserializer<>(CustomMessage.class, objectMapper()));

		ConcurrentKafkaListenerContainerFactory<String, CustomMessage> listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();
		listenerContainerFactory.setConsumerFactory(consumerFactory);

		return listenerContainerFactory;
	}

	@Bean
	public ConsumerListener consumerListener() {
		return new ConsumerListener();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return mapper;
	}
}
