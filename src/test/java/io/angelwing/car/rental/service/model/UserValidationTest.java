package io.angelwing.car.rental.service.model;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
import java.util.stream.Collectors;

import static io.angelwing.car.rental.service.generator.UserGenerator.generateRandomUser;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserValidationTest {

    @Autowired
    private Validator validator;

    @Test
    void shouldValidateUser() {
        final User user = generateRandomUser();

        Set<ConstraintViolation<User>> violations = validator.validate(user);

        assertThat(violations).isEmpty();
    }

    @Test
    void shouldNotValidateUser() {
        final User user = User.builder().build();

        Set<String> violations = validator.validate(user).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).containsOnly(
                "Email is missing",
                "Last name is missing",
                "First name is missing"
        );
    }

    @Test
    void shouldNotValidateUserWhenEmailIsInvalid() {
        final User user = generateRandomUser("jdwada");

        Set<String> violations = validator.validate(user).stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        assertThat(violations).contains(
                "Email format is wrong"
        );
    }

}
