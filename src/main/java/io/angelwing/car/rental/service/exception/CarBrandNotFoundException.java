package io.angelwing.car.rental.service.exception;

import java.util.UUID;

public class CarBrandNotFoundException extends RuntimeException {

    public CarBrandNotFoundException(UUID id) {
        super("Car brand with id=" + id + " not found!");
    }
}
