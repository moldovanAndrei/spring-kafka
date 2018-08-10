package org.spring.kafka.avro.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot App for the kafka consumer.
 *
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
@SpringBootApplication
public class AvroConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvroConsumerApplication.class);
	}
}
