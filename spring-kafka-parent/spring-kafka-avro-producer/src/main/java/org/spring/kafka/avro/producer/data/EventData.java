package org.spring.kafka.avro.producer.data;

/**
 * Event POJO.
 * 
 * @author Andrei Moldovan
 * @since 10.08.2018
 */
public class EventData {

	private final String eventType;
	private final byte[] data;

	public EventData(String eventType, byte[] data) {
		super();
		this.eventType = eventType;
		this.data = data;
	}

	public String getEventType() {
		return this.eventType;
	}

	public byte[] getData() {
		return this.data;
	}
}
