package io.angelwing.car.rental.service.controller;

import io.angelwing.car.rental.service.exception.UserNotFoundException;
import io.angelwing.car.rental.service.model.User;
import io.angelwing.car.rental.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("users/{email}")
    public User findByEmail(@PathVariable final String email) {
        return userService.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    @PostMapping("users")
    public User save(@RequestBody final User user) {
        return userService.save(user);
    }
}
