package org.spring.kafka.datagenerator.data.avro.serialization;

import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;

/**
 * Avro deserializer.
 *
 * @author Andrei Moldovan
 * @since 09.08.2018
 */
public class AvroSerializer<T extends SpecificRecordBase> implements Serializer<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AvroSerializer.class);

	@Override
	public byte[] serialize(String topic, T data) {
		LOGGER.debug("data to serialize='{}'", data);

		Injection<GenericRecord, byte[]> genericRecordInjection = GenericAvroCodecs.toBinary(data.getSchema());
		byte[] result = genericRecordInjection.apply(data);

		LOGGER.debug("serialized data='{}'", DatatypeConverter.printHexBinary(result));
		return result;
	}

	@Override
	public void close() {
		// No-op
	}

	/**
	 * @see org.apache.kafka.common.serialization.Serializer#configure(java.util.Map,
	 *      boolean)
	 */
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// No-op
	}
}
