package io.angelwing.car.rental.service;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Optional;

@SpringBootApplication
public class CarRentalApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarRentalApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfiguration(final Environment environment) {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                Optional.ofNullable(environment.getProperty("spring.rest.cors.allowedOrigins"))
                        .ifPresent(allowedOrigins -> registry.addMapping("/**").allowedOrigins(allowedOrigins));
            }
        };
    }

}
