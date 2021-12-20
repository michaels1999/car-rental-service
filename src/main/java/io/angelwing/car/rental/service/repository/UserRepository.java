package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);

    User save(User user);
}
