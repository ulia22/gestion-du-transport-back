package dev.gestiondutransportback.utils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ParseDeserializer extends StdDeserializer<LocalDateTime> {
	/** serialVersionUID : long */
	private static final long serialVersionUID = 1L;

	public ParseDeserializer() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		LocalDateTime timeUtc = LocalDateTime.parse(p.getValueAsString(),
				DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"));
		return LocalDateTimeUtils.fromUTCtoZone(timeUtc, "Europe/Paris");
	}
}