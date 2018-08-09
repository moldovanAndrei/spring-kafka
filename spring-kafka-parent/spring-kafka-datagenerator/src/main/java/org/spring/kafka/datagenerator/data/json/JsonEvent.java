package org.spring.kafka.datagenerator.data.json;

/**
 * Json event representation object.
 *
 * @author Andrei Moldovan
 * @since 09.08.2018
 */
public class JsonEvent {

	private final long id;
	private final String type;
	private final JsonGps gps;

	public JsonEvent(long id, String type, JsonGps gps) {
		super();
		this.id = id;
		this.type = type;
		this.gps = gps;
	}

	public long getId() {
		return this.id;
	}

	public String getType() {
		return this.type;
	}

	public JsonGps getGps() {
		return this.gps;
	}
}
