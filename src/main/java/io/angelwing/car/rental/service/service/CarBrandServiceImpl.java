package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.repository.CarBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    private final CarBrandRepository carBrandRepository;

    @Autowired
    public CarBrandServiceImpl(final CarBrandRepository carBrandRepository) {
        this.carBrandRepository = carBrandRepository;
    }

    @Override
    public Collection<CarBrand> findAll() {
        return carBrandRepository.findAll();
    }

    @Override
    public Optional<CarBrand> findById(UUID id) {
        return carBrandRepository.findById(id);
    }

    @Override
    public CarBrand save(CarBrand carBrand) {
        return carBrandRepository.save(carBrand);
    }
}
