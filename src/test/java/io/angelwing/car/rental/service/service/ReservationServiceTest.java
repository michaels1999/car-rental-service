package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.Reservation;
import io.angelwing.car.rental.service.repository.ReservationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static io.angelwing.car.rental.service.generator.ReservationGenerator.generateRandomReservation;
import static io.angelwing.car.rental.service.generator.ReservationGenerator.generateRandomReservations;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class ReservationServiceTest {

    private final ReservationRepository reservationRepository = mock(ReservationRepository.class);

    private final ReservationService reservationService = new ReservationServiceImpl(reservationRepository);

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(reservationRepository);
    }

    @Test
    void addReservation() {
        final UUID reservationId = UUID.randomUUID();
        final Reservation expectedReservation = generateRandomReservation(reservationId);

        when(reservationRepository.save(expectedReservation)).thenReturn(expectedReservation);
        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(expectedReservation));

        reservationService.save(expectedReservation);

        Optional<Reservation> actualReservation = reservationService.findById(reservationId);
        verify(reservationRepository).save(expectedReservation);
        verify(reservationRepository).findById(reservationId);

        assertThat(actualReservation).contains(expectedReservation);
    }

    @Test
    void findAllReservation() {
        final Collection<Reservation> expectedReservation = generateRandomReservations(5);
        when(reservationRepository.findAll()).thenReturn(expectedReservation);

        Collection<Reservation> actualReservation = reservationService.findAll();
        verify(reservationRepository).findAll();

        assertThat(actualReservation).isEqualTo(expectedReservation);
    }
}