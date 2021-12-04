package io.angelwing.car.rental.service.exception;

import java.util.UUID;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(UUID id) {
        super("Reservation with id=" + id + " not found!");
    }
}
