/*
 * spring-kafka-producer:ProducerApplication.java
 */
package com.andrei.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot App for the kafka consumer.
 *
 * @author Andrei Moldovan
 * @since 29.01.2018
 */
@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class);
	}
}
