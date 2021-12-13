package io.angelwing.car.rental.service.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

import static io.angelwing.car.rental.service.generator.ReservationGenerator.generateRandomReservation;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReservationValidationTest {

    @Autowired
    private Validator validator;

    @Test
    void shouldValidateReservation() {
        final Reservation reservation = generateRandomReservation();

        Set<ConstraintViolation<Reservation>> violations = validator.validate(reservation);

        assertThat(violations).isEmpty();
    }

    @Test
    void shouldNotValidateWhenReservationFieldsAreNull() {
        final Reservation reservation = Reservation.builder().build();

        Set<String> violations = validator.validate(reservation).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains(
                "Start date is missing",
                "End date is missing",
                "Vin code is missing"
        );
    }

    @Test
    void shouldNotValidateWhenReservationStartDateIsNotBeforeNow() {
        final Reservation reservation = Reservation.builder()
                .withStartDate(LocalDateTime.now().plusDays(1)).build();

        Set<String> violations = validator.validate(reservation).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Start date should be before now");
    }

    void shouldNotValidateWhenReservationEndDateIsBeforeNow() {
        final Reservation reservation = Reservation.builder()
                .withEndDate(LocalDateTime.now().minusDays(1))
                .build();

        Set<String> violations = validator.validate(reservation).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("End date should be after now");
    }

}
