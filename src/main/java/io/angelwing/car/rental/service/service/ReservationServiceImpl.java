package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.Reservation;
import io.angelwing.car.rental.service.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(final ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Collection<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findById(final UUID id) {
        return reservationRepository.findById(id);
    }

    @Override
    public Reservation save(final Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
