package org.ies.tierno.airline.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tools.jackson.databind.ObjectMapper;

import java.util.Scanner;

@Configuration
public class AirlineConfiguration {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public ObjectMapper om() {
        return new ObjectMapper();
    }
}
