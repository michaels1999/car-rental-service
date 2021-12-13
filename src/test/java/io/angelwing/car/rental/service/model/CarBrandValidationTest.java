package io.angelwing.car.rental.service.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static io.angelwing.car.rental.service.generator.CarBrandGenerator.generateRandomCarBrand;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CarBrandValidationTest {

    @Autowired
    private Validator validator;

    @Test
    void shouldValidateCarBrand() {
        final CarBrand carBrand = generateRandomCarBrand();

        Set<ConstraintViolation<CarBrand>> violations = validator.validate(carBrand);

        assertThat(violations).isEmpty();
    }

    @Test
    void shouldNotValidateWhenCarBrandNameIsNull() {
        final CarBrand carBrand = CarBrand.builder().build();

        Set<String> violations = validator.validate(carBrand).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Car brand name should not be empty");
    }

    @Test
    void shouldNotValidateWhenCarBrandNameIsBlank() {
        final CarBrand carBrand = CarBrand.builder().withName("").build();

        Set<String> violations = validator.validate(carBrand).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Car brand name should not be empty");
    }
}
