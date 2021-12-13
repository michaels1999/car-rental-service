package io.angelwing.car.rental.service.controller;

import io.angelwing.car.rental.service.exception.ReservationNotFoundException;
import io.angelwing.car.rental.service.model.Reservation;
import io.angelwing.car.rental.service.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(final ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("reservations")
    public Collection<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("reservations/{id}")
    public Reservation findById(@PathVariable final UUID id) {
        return reservationService.findById(id)
                .orElseThrow(ReservationNotFoundException::new);
    }

    @PostMapping("reservations")
    public Reservation save(@RequestBody final Reservation reservation) {
        return reservationService.save(reservation);
    }
}
