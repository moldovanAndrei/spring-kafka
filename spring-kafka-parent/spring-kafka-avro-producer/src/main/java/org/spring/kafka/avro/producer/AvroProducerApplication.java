package org.spring.kafka.avro.producer;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Spring Boot App for the avro producer.
 *
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
@SpringBootApplication
public class AvroProducerApplication {

	public static void main(final String[] args) throws IOException, InterruptedException, URISyntaxException {
		final ConfigurableApplicationContext context = SpringApplication.run(AvroProducerApplication.class);
		final AvroEventProducer producer = context.getBean(AvroEventProducer.class);
		producer.produce();
	}
}
