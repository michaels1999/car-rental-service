package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.Car;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CarRepository {

    Collection<Car> findAll();

    Optional<Car> findById(UUID id);
}
