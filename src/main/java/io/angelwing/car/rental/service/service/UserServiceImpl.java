package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.User;
import io.angelwing.car.rental.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByEmail(final String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean exists(final String email) {
        return userRepository.exists(email);
    }
}
