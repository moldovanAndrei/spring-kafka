package org.spring.kafka.datagenerator.data.json;

/**
 * Json gps representation object.
 *
 * @author Andrei Moldovan
 * @since 09.08.2018
 */
public class JsonGps {

	private final double long$;
	private final double lat;

	public JsonGps(double long$, double lat) {
		super();
		this.long$ = long$;
		this.lat = lat;
	}

	public double getLong() {
		return this.long$;
	}

	public double getLat() {
		return this.lat;
	}
}
