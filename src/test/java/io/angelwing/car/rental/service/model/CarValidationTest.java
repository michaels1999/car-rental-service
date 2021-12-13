package io.angelwing.car.rental.service.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static io.angelwing.car.rental.service.generator.CarGenerator.generateRandomCar;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CarValidationTest {

    @Autowired
    private Validator validator;

    @Test
    void shouldValidateCar() {
        final Car car = generateRandomCar();

        Set<ConstraintViolation<Car>> violations = validator.validate(car);

        assertThat(violations).isEmpty();
    }

    @Test
    void shouldNotValidateWhenCarFieldsAreNull() {
        final Car car = Car.builder().build();

        Set<String> violations = validator.validate(car).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains(
                "Car make is missing",
                "Color is missing",
                "Regular price is missing",
                "Young price is missing",
                "Elder price is missing",
                "Inexperienced price is missing"
        );
    }

    @Test
    void shouldNotValidateCarWhenRegularPriceIsLessThanZero() {
        final Car car = Car.builder()
                .withRegularPrice(-17.0).build();

        Set<String> violations = validator.validate(car).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Regular price should be greater than zero");
    }

    @Test
    void shouldNotValidateCarWhenYoungPriceIsLessThanZero() {
        final Car car = Car.builder()
                .withYoungPrice(-18.0).build();

        Set<String> violations = validator.validate(car).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Young price should be greater than zero");
    }

    @Test
    void shouldNotValidateCarWhenElderPriceIsLessThanZero() {
        final Car car = Car.builder()
                .withElderPrice(-12.0)
                .build();

        Set<String> violations = validator.validate(car).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Elder price should be greater than zero");
    }

    @Test
    void shouldNotValidateCarWhenInexperiencedPriceIsLessThanZero() {
        final Car car = Car.builder()
                .withInexperiencedPrice(-13.0)
                .build();

        Set<String> violations = validator.validate(car).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains("Inexperienced price should be greater than zero");
    }
}
