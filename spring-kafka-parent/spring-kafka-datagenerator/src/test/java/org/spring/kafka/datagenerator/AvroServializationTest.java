package org.spring.kafka.datagenerator;

import org.junit.Assert;
import org.junit.Test;
import org.spring.kafka.datagenerator.data.avro.AvroEvent;
import org.spring.kafka.datagenerator.data.avro.AvroGps;
import org.spring.kafka.datagenerator.data.avro.serialization.AvroDeserializer;
import org.spring.kafka.datagenerator.data.avro.serialization.AvroSerializer;
import org.spring.kafka.datagenerator.data.avro.serialization.EventAvroDeserializer;

/**
 * Avro serialization test class.
 *
 * @author Andrei Moldovan
 * @since 09.08.2018
 */
public class AvroServializationTest {

	@Test
	public void testSerialization() {

		try (AvroSerializer<AvroEvent> serializer = new AvroSerializer<>();
				AvroDeserializer<AvroEvent> deserializer = new EventAvroDeserializer()) {

			AvroGps gps = new AvroGps(12.55, 30.12);
			AvroEvent event = new AvroEvent(1l, "roadblock", gps);

			byte[] eventBytes = serializer.serialize("topic", event);
			AvroEvent deserializedEvent = deserializer.deserialize("topic", eventBytes);

			Assert.assertEquals(event, deserializedEvent);
		}
	}
}
