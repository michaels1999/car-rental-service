package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    User save(User user);
}
