package io.angelwing.car.rental.service.generator;

import io.angelwing.car.rental.service.model.User;

public class UserGenerator {

    public UserGenerator() {
        // NOOP
    }

    public static User generateRandomUser() {
        return generateRandomUser("user@gmai.com");
    }

    public static User generateRandomUser(final String email) {
        return User.builder()
                .withEmail(email)
                .withFirstName("X")
                .withLasName("Y")
                .build();
    }
}
