package org.ies.tierno.airline.model;

import java.util.List;

public record Airline(String name, List<Flight> flights) {
}
