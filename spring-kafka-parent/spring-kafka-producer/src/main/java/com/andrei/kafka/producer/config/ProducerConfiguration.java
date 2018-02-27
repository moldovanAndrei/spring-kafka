/*
 * spring-kafka-producer:ProducerConfiguration.java
 */
package com.andrei.kafka.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.andrei.kafka.producer.core.CustomMessage;
import com.andrei.kafka.producer.core.CustomMessageProducer;
import com.andrei.kafka.producer.core.SimpleMessageProducer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

/**
 * Kafka producer configuration class.
 * 
 * @author Andrei Moldovan
 * @since 29.01.2018
 */
@Configuration
public class ProducerConfiguration {

	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, CustomMessage> greetingProducerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		DefaultKafkaProducerFactory<String, CustomMessage> factory = new DefaultKafkaProducerFactory<>(configProps);
		// Override {@link ObjectMapper} to alow serialization of Java 8 types.
		JsonSerializer serializer = new JsonSerializer<>(objectMapper());
		// Remove type info, so the client can deserialize the object.
		serializer.setAddTypeInfo(false);
		factory.setValueSerializer(serializer);
		return factory;
	}

	@Bean
	public KafkaTemplate<String, CustomMessage> customKafkaTemplate() {
		return new KafkaTemplate<>(greetingProducerFactory());
	}

	@Bean
	public SimpleMessageProducer messageProducer() {
		return new SimpleMessageProducer();
	}

	@Bean
	public CustomMessageProducer customMessageProducer() {
		return new CustomMessageProducer();
	}

	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		return mapper;
	}
}
