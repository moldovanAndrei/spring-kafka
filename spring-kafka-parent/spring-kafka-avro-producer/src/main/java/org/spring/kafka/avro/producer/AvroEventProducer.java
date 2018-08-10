package org.spring.kafka.avro.producer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.avro.file.DataFileStream;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.kafka.avro.producer.data.EventParser;
import org.spring.kafka.datagenerator.data.avro.AvroEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.twitter.bijection.Injection;
import com.twitter.bijection.avro.GenericAvroCodecs;

/**
 * Avro event producer implementation.
 *
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
public class AvroEventProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(AvroEventProducer.class);

	@Value(value = "${kafka.producer.eventformat}")
	private String eventFormat;
	@Value(value = "${kafka.producer.file}")
	private String eventFile;

	private EventSender eventSender;
	private EventParser eventParser;

	@Autowired
	public AvroEventProducer(final EventSender eventSender, final EventParser eventParser) {
		this.eventSender = eventSender;
		this.eventParser = eventParser;
	}

	public void produce() throws FileNotFoundException, IOException, URISyntaxException {
		long count = 0;
		final long eventSenderStartTime = System.currentTimeMillis();

		try (DataFileStream<AvroEvent> dataFileStream = getDataFileStream()) {
			final Injection<AvroEvent, byte[]> recordInjection = GenericAvroCodecs.toBinary(dataFileStream.getSchema());
			AvroEvent event = null;
			while (dataFileStream.hasNext()) {
				count++;
				event = dataFileStream.next(event);
				this.eventSender.send(this.eventParser.parseEventRecord(event, recordInjection));
			}

			LOGGER.info("Producer {} events", count);
			final long eventSenderTimeTaken = System.currentTimeMillis() - eventSenderStartTime;
			LOGGER.info("Execution time: {}ms", eventSenderTimeTaken);
		} catch (final IOException e) {
			throw e;
		}
	}

	private DataFileStream<AvroEvent> getDataFileStream() throws IOException, URISyntaxException {
		final DatumReader<AvroEvent> eventDatumReader = new SpecificDatumReader<>(AvroEvent.class);
		return new DataFileStream<>(getFile(this.eventFile), eventDatumReader);
	}

	private InputStream getFile(final String filePath) throws URISyntaxException, FileNotFoundException {
		return this.getClass().getResourceAsStream(filePath);
	}
}
