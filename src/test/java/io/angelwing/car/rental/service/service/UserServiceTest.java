package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.User;
import io.angelwing.car.rental.service.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static io.angelwing.car.rental.service.generator.UserGenerator.generateRandomUser;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);

    private final UserService userService = new UserServiceImpl(userRepository);

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    void findUserByEmail() {
        final String userEmail = "mihaidodi98@gmail.com";
        final User expectedUser = generateRandomUser(userEmail);

        when(userRepository.save(expectedUser)).thenReturn(expectedUser);
        when(userRepository.findByEmail(userEmail)).thenReturn(Optional.of(expectedUser));

        userService.save(expectedUser);

        Optional<User> actualUser = userService.findByEmail(userEmail);
        verify(userRepository).save(expectedUser);
        verify(userRepository).findByEmail(userEmail);

        assertThat(actualUser).contains(expectedUser);

    }

}