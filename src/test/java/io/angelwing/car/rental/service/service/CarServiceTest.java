package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.Car;
import io.angelwing.car.rental.service.repository.CarRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static io.angelwing.car.rental.service.generator.CarGenerator.generateRandomCar;
import static io.angelwing.car.rental.service.generator.CarGenerator.generateRandomCars;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class CarServiceTest {

    private final CarRepository carRepository = mock(CarRepository.class);

    private final CarService carService = new CarServiceImpl(carRepository);

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(carRepository);
    }

    @Test
    void addCar() {
        final UUID carId = UUID.randomUUID();
        final Car expectedCar = generateRandomCar(carId);

        when(carRepository.save(expectedCar)).thenReturn(expectedCar);
        when(carRepository.findById(carId)).thenReturn(Optional.of(expectedCar));

        carService.save(expectedCar);

        Optional<Car> actualCar = carService.findById(carId);
        verify(carRepository).save(expectedCar);
        verify(carRepository).findById(carId);

        assertThat(actualCar).contains(expectedCar);
    }

    @Test
    void findAllCar() {
        final Collection<Car> expectedCar = generateRandomCars(5);
        when(carRepository.findAll()).thenReturn(expectedCar);

        final Collection<Car> actualCars = carService.findAll();
        verify(carRepository).findAll();

        assertThat(actualCars).containsExactlyInAnyOrderElementsOf(expectedCar);
    }

}