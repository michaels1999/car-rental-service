package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.CarMake;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CarMakeService {

    Collection<CarMake> findAll();

    Optional<CarMake> findById(UUID id);

    CarMake save(CarMake carMake);

    Collection<CarMake> findByYear(Integer year);
}
