package io.angelwing.car.rental.service.exception;

public class VinCodeNotFoundException extends RuntimeException {

    public VinCodeNotFoundException(String id) {
        super("Vin Code with id=" + id + " not found!");
    }
}
