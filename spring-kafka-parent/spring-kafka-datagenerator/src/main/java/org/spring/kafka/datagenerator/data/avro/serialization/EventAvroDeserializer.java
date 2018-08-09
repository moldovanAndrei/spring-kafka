package org.spring.kafka.datagenerator.data.avro.serialization;

import org.spring.kafka.datagenerator.data.avro.AvroEvent;

/**
 * Event specific avro deserializer implementation.
 * 
 * @author Andrei Moldovan
 * @since 29.03.2018
 */
public class EventAvroDeserializer extends AvroDeserializer {

	/**
	 * Constructor.
	 */
	public EventAvroDeserializer() {
		super(AvroEvent.class);
	}
}
