package org.ies.tierno.airline.components;

import org.ies.tierno.airline.model.Airline;
import org.ies.tierno.airline.model.Flight;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tools.jackson.core.JacksonException;

import java.util.List;
import java.util.Scanner;

@Component
public class AirlineProgram implements CommandLineRunner  {

    private final Scanner scanner;
    private final AirlineReader reader;
    private final AirlineFilter filter;

    public AirlineProgram(Scanner scanner, AirlineReader reader, AirlineFilter filter) {
        this.scanner = scanner;
        this.reader = reader;
        this.filter = filter;
    }

    public void run() {
        System.out.print("Introduce el origen: ");
        String origin = scanner.nextLine();

        try {
            Airline airline = reader.read();
            List<Flight> flights = filter.filterByOrigin(airline, origin);

            if (flights.isEmpty()) {
                System.out.println("La aerolínea " + airline.name() + " no tiene vuelos desde " + origin + ".");
            } else {
                System.out.println("Vuelos de " + airline.name() + " con origen en " + origin + ":");
                for (Flight f : flights) {
                    System.out.printf("  %-8s %s -> %s  (salida: %s)%n",
                            f.code(), f.origin(), f.destination(), f.departureTime());
                }
            }
        } catch (JacksonException e) {
            System.out.println("No se ha podido leer el fichero de la aerolínea: " + e.getMessage());
        }
    }

    @Override
    public void run(String... args) throws Exception {
        run();
    }
}
