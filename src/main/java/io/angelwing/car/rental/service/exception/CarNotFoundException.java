package io.angelwing.car.rental.service.exception;

import java.util.UUID;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException(UUID id) {
        super("Car with id=" + id + " not found!");
    }
}
