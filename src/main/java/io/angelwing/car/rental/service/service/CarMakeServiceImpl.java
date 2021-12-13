package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.repository.CarMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class CarMakeServiceImpl implements CarMakeService {

    private final CarMakeRepository carMakeRepository;

    @Autowired
    public CarMakeServiceImpl(final CarMakeRepository carMakeRepository) {
        this.carMakeRepository = carMakeRepository;
    }

    @Override
    public Collection<CarMake> findAll() {
        return carMakeRepository.findAll();
    }

    @Override
    public Optional<CarMake> findById(final UUID id) {
        return carMakeRepository.findById(id);
    }

    @Override
    public CarMake save(final CarMake carMake) {
        return carMakeRepository.save(carMake);
    }

}
