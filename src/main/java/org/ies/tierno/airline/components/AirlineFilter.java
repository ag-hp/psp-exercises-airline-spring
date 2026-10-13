package org.ies.tierno.airline.components;

import org.ies.tierno.airline.model.Airline;
import org.ies.tierno.airline.model.Flight;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AirlineFilter {

    public List<Flight> filterByOrigin(Airline airline, String origin) {
        return airline.flights().stream()
                .filter(f -> f.origin().equalsIgnoreCase(origin))
                .toList();
    }
}
