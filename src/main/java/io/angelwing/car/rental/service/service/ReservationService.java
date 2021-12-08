package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.Reservation;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ReservationService {

    Collection<Reservation> findAll();

    Optional<Reservation> findById(UUID id);

    Reservation save(Reservation reservation);
}
