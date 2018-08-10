package org.spring.kafka.avro.producer.data;

import org.spring.kafka.datagenerator.data.avro.AvroEvent;

import com.twitter.bijection.Injection;

/**
 * Simple event parser.
 *
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
public class EventParser {

	public EventData parseEventRecord(AvroEvent event, Injection<AvroEvent, byte[]> recordInjection) {
		final String eventType = event.getType();
		byte[] bytes = recordInjection.apply(event);

		return new EventData(eventType, bytes);
	}
}
