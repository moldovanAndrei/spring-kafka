package org.spring.kafka.datagenerator.writer;

import java.io.File;
import java.io.IOException;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.spring.kafka.datagenerator.data.avro.AvroEvent;
import org.spring.kafka.datagenerator.data.avro.AvroGps;

/**
 * Demo avro file writer.
 * 
 * @author Andrei Moldovan.
 * @since 09.08.2018
 */
public class AvroWriter {

	public static void main(String[] args) throws IOException {
		writeAvroData(1_000_000);
	}

	private static void writeAvroData(int numberOfEntries) throws IOException {

		GenericDatumWriter<AvroEvent> datum = new GenericDatumWriter<>(AvroEvent.SCHEMA$);
		DataFileWriter<AvroEvent> writer = new DataFileWriter<>(datum);

		final AvroGps gps = new AvroGps(12.55, 30.12);
		final AvroEvent event = new AvroEvent(1l, "roadblock", gps);

		File file = new File("events.avro");
		if (file.exists()) {
			file.createNewFile();
		}

		writer.create(AvroEvent.SCHEMA$, file);
		for (int i = 0; i < numberOfEntries; i++) {
			writer.append(event);
		}
		writer.close();
	}
}
