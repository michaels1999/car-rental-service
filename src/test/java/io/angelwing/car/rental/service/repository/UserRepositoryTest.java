package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.User;
import io.angelwing.car.rental.service.util.ClearDatabaseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static io.angelwing.car.rental.service.generator.UserGenerator.generateRandomUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClearDatabaseRepository clearDatabaseRepository;

    @AfterEach
    void tearDown() {
        clearDatabaseRepository.clear();
    }

    @Test
    void shouldFindUserByEmail() {
        final User expectedUser = prepareUser();

        final Optional<User> actualUser = userRepository.findByEmail(expectedUser.getEmail());

        assertThat(actualUser)
                .usingRecursiveComparison()
                .isEqualTo(Optional.of(expectedUser));
    }

    @Test
    void shouldThrowViolationExceptionWhenSavingTheSameUserTwice() {
        final User user = generateRandomUser();
        userRepository.save(user);

        assertThatExceptionOfType(DataIntegrityViolationException.class)
                .isThrownBy(() -> userRepository.save(user));
    }

    private User prepareUser() {
        return userRepository.save(generateRandomUser("user@gmail.com"));
    }
}