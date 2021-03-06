package io.angelwing.car.rental.service.generator;

import io.angelwing.car.rental.service.model.Reservation;
import io.angelwing.car.rental.service.model.User;
import io.angelwing.car.rental.service.model.VinCode;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static io.angelwing.car.rental.service.generator.UserGenerator.generateRandomUser;
import static io.angelwing.car.rental.service.generator.VinCodeGenerator.generateRandomVinCode;

public final class ReservationGenerator {

    private ReservationGenerator() {
        // NOOP
    }

    public static Reservation generateRandomReservation() {
        return generateRandomReservation((UUID) null);
    }

    public static Reservation generateRandomReservation(final User user) {
        return generateRandomReservation(null, user);
    }

    public static Reservation generateRandomReservation(final VinCode vinCode, final User user) {
        return generateRandomReservation(null, vinCode, user);
    }

    public static Reservation generateRandomReservation(final UUID id) {
        return generateRandomReservation(id, generateRandomVinCode());
    }

    private static Reservation generateRandomReservation(final UUID id, final VinCode vinCode) {
        return generateRandomReservation(id, vinCode, generateRandomUser());
    }

    private static Reservation generateRandomReservation(final UUID id, final VinCode vinCode, final User user) {
        return Reservation.builder()
                .withId(id)
                .withUser(user)
                .withVinCode(vinCode)
                .withStartDate(LocalDateTime.now().minusDays(1))
                .withEndDate(LocalDateTime.now().plusDays(1))
                .build();
    }

    public static Collection<Reservation> generateRandomReservations(final int numberOfReservations) {
        final Collection<Reservation> reservations = new ArrayList<>();

        for (int i = 0; i < numberOfReservations; i++) {
            reservations.add(generateRandomReservation());
        }
        return reservations;
    }
}
