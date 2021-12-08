package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.CarBrand;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface CarBrandRepository {
    Collection<CarBrand> findAll();

    Optional<CarBrand> findById(UUID id);

    CarBrand save(CarBrand carBrand);
}
