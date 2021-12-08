package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.Car;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CarService {

    Collection<Car> findAll();

    Optional<Car> findById(UUID id);

    Car save(Car car);
}
