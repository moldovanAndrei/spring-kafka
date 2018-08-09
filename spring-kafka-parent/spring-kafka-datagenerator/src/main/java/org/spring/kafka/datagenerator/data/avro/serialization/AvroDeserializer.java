package org.spring.kafka.datagenerator.data.avro.serialization;

import java.util.Arrays;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract avro deserializer.
 * 
 * @author Andrei Moldovan
 * @since 29.03.2018
 */
public abstract class AvroDeserializer<T extends SpecificRecordBase> implements Deserializer<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AvroDeserializer.class);

	protected final Class<T> targetType;

	public AvroDeserializer(Class<T> targetType) {
		this.targetType = targetType;
	}

	/**
	 * @see org.apache.kafka.common.serialization.Deserializer#deserialize(java.lang.String,
	 *      byte[])
	 */
	@Override
	public T deserialize(String topic, byte[] data) {
		try {
			T result = null;

			if (data != null) {
				LOGGER.debug("data='{}'", DatatypeConverter.printHexBinary(data));
				DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>(
						this.targetType.newInstance().getSchema());
				Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);

				result = (T) datumReader.read(null, decoder);
				LOGGER.debug("deserialized data='{}'", result);
			}
			return result;
		} catch (Exception ex) {
			throw new SerializationException(
					"Can't deserialize data '" + Arrays.toString(data) + "' from topic '" + topic + "'", ex);
		}
	}

	/**
	 * @see org.apache.kafka.common.serialization.Deserializer#configure(java.util.Map,
	 *      boolean)
	 */
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// No-op
	}

	/**
	 * @see org.apache.kafka.common.serialization.Deserializer#close()
	 */
	@Override
	public void close() {
		// No-op
	}
}
