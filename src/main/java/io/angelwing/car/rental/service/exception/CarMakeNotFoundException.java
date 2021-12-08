package io.angelwing.car.rental.service.exception;

import java.util.UUID;

public class CarMakeNotFoundException extends RuntimeException {

    public CarMakeNotFoundException(UUID id) {
        super("Car make with id=" + id + " not found!");
    }
}
