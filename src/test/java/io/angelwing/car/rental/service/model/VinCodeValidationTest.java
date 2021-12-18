package io.angelwing.car.rental.service.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static io.angelwing.car.rental.service.generator.VinCodeGenerator.generateRandomVinCode;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VinCodeValidationTest {

    @Autowired
    private Validator validator;

    @Test
    void shouldValidateVinCode() {
        final VinCode vinCode = generateRandomVinCode();

        Set<ConstraintViolation<VinCode>> violations = validator.validate(vinCode);

        assertThat(violations).isEmpty();
    }

    @Test
    void shouldNotValidateWhenVinCodeFieldsAreNull() {
        final VinCode vinCode = VinCode.builder().build();

        Set<String> violations = validator.validate(vinCode).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).containsOnly(
                "Car is missing",
                "Available is missing"
        );
    }
}
