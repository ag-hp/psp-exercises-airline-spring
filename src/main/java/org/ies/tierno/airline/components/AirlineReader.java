package org.ies.tierno.airline.components;

import org.ies.tierno.airline.model.Airline;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.nio.file.Path;

@Component
public class AirlineReader {

    private final ObjectMapper mapper;
    private final String filePath;

    public AirlineReader(ObjectMapper mapper, @Value("${airline.file}") String filePath) {
        this.mapper = mapper;
        this.filePath = filePath;
    }

    public Airline read() {
        return mapper.readValue(Path.of(filePath).toFile(), Airline.class);
    }
}
