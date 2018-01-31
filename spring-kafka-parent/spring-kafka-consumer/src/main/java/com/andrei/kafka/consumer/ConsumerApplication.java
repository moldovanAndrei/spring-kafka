/*
 * spring-kafka-consumer:ConsumerApplication.java
 */
package com.andrei.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.andrei.kafka.consumer.core.ConsumerListener;

/**
 * Spring Boot App for the kafka consumer.
 *
 * @author Andrei Moldovan
 * @since 29.01.2018
 */
@SpringBootApplication
public class ConsumerApplication {

	public static void main(String[] args) throws InterruptedException {
		ConfigurableApplicationContext context = SpringApplication.run(ConsumerApplication.class);
		ConsumerListener consumerListener = context.getBean(ConsumerListener.class);
	}
}
