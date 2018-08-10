package org.spring.kafka.avro.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.spring.kafka.avro.producer.AvroEventProducer;
import org.spring.kafka.avro.producer.EventSender;
import org.spring.kafka.avro.producer.data.EventParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * Avro event producer configuration class.
 *
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
@Configuration
public class AvroEventProducerConfiguration {

	@Value(value = "${kafka.bootstrapServers}")
	private String bootstrapAddress;

	@Bean
	public static PropertyPlaceholderConfigurer properties() {
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		ppc.setIgnoreUnresolvablePlaceholders(true);
		return ppc;
	}

	@Bean
	public ProducerFactory<Long, byte[]> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, ByteArraySerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<Long, byte[]> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public AvroEventProducer avroEventProducer() {
		return new AvroEventProducer(eventSender(), eventParser());
	}

	@Bean
	public EventSender eventSender() {
		return new EventSender(kafkaTemplate());
	}

	@Bean
	public EventParser eventParser() {
		return new EventParser();
	}
}
