package com.zuehlke.jso.api;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {


    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (localDateTime == null) {
            jsonGenerator.writeNull();
        } else {
            String formattedDateTime = localDateTime.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            jsonGenerator.writeString(formattedDateTime);
        }

    }
}
