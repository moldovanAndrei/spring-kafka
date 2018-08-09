package org.spring.kafka.datagenerator.writer;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.spring.kafka.datagenerator.data.json.JsonEvent;
import org.spring.kafka.datagenerator.data.json.JsonGps;

/**
 * Demo json file writer.
 * 
 * @author Andrei Moldovan.
 * @since 09.08.2018
 */
public class JsonWriter {

	public static void main(String[] args) throws IOException {
		writeJsonData(1_000_000);
	}

	private static void writeJsonData(int numberOfEntries) throws IOException {
		final JsonGps gps = new JsonGps(12.55, 30.12);
		final JsonEvent event = new JsonEvent(1l, "roadblock", gps);

		List<JsonEvent> events = new ArrayList<>();
		for (int i = 0; i < numberOfEntries; i++) {
			events.add(event);
		}

		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("events.json"), events);
	}
}
