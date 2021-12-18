package io.angelwing.car.rental.service.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static io.angelwing.car.rental.service.generator.CarMakeGenerator.generateRandomCarMake;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CarMakeValidationTest {

    @Autowired
    private Validator validator;

    @Test
    void shouldValidateCarMake() {
        final CarMake carMake = generateRandomCarMake();

        Set<ConstraintViolation<CarMake>> violations = validator.validate(carMake);

        assertThat(violations).isEmpty();
    }

    @Test
    void shouldNotValidateWhenCarMakeFieldsAreNull() {
        final CarMake carMake = CarMake.builder().build();

        Set<String> violations = validator.validate(carMake).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).containsOnly(
                "Body type is required",
                "Year is missing",
                "Combustion type is required",
                "Car make name should not be empty",
                "Engine volume is missing",
                "Car brand is missing");
    }

    @Test
    void shouldNotValidateWhenCarMakeYearIsLessThan1900() {
        final CarMake carMake = CarMake.builder()
                .withYear(1800)
                .build();

        Set<String> violations = validator.validate(carMake).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Specified year is less than 1900");
    }

    @Test
    void shouldNotValidateWhenCarMakeYearIsGreaterThan2021() {
        final CarMake carMake = CarMake.builder()
                .withYear(2022).build();

        Set<String> violations = validator.validate(carMake).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Specified year is greater than 2021");
    }

    @Test
    void shouldNotValidateWhenCarMakeEngineVolumeIsLessThanZero() {
        final CarMake carMake = CarMake.builder()
                .withEngineVolume(-1.0).build();

        Set<String> violations = validator.validate(carMake).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Engine volume could not be less than zero");
    }

    @Test
    void shouldNotValidateWhenCarMakeEngineVolumeIsGreaterThanTen() {
        final CarMake carMake = CarMake.builder()
                .withEngineVolume(11.0).build();

        Set<String> violations = validator.validate(carMake).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Engine volume is greater than 10");
    }
}
