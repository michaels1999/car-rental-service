package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.BodyType;
import io.angelwing.car.rental.service.model.CarMake;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CarMakeRepository {

    Collection<CarMake> findAll();

    Optional<CarMake> findById(UUID id);

    CarMake save(CarMake carMake);

    Collection<CarMake> findByBodyType(BodyType bodyType);
}
