package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.Car;
import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.util.ClearDatabaseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.IntStream;

import static io.angelwing.car.rental.service.generator.CarBrandGenerator.generateRandomCarBrand;
import static io.angelwing.car.rental.service.generator.CarGenerator.generateRandomCar;
import static io.angelwing.car.rental.service.generator.CarMakeGenerator.generateRandomCarMake;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMakeRepository carMakeRepository;

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Autowired
    private ClearDatabaseRepository clearDatabaseRepository;

    @AfterEach
    void tearDown() {
        clearDatabaseRepository.clear();
    }

    @Test
    void shouldFindCarById() {
        final Car expectedCar = prepareCar();

        final Optional<Car> actualCar = carRepository.findById(expectedCar.getId());

        assertThat(actualCar)
                .usingRecursiveComparison()
                .isEqualTo(Optional.of(expectedCar));
    }

    private Car prepareCar() {
        final CarBrand carBrand = carBrandRepository.save(generateRandomCarBrand());
        final CarMake carMake = carMakeRepository.save(generateRandomCarMake(carBrand));

        return carRepository.save(generateRandomCar(carMake));
    }

    @Test
    void shouldFindAllCars() {
        final Collection<Car> expectedCars = prepareCars(5);

        final Collection<Car> actualCars = carRepository.findAll();

        assertThat(actualCars)
                .usingRecursiveComparison()
                .isEqualTo(expectedCars);
    }

    private Collection<Car> prepareCars(final int numberOfCar) {
        final Collection<Car> expectedCar = new ArrayList<>();

        IntStream.rangeClosed(1, numberOfCar)
                .forEach(i -> expectedCar.add(prepareCar()));

        return expectedCar;
    }

}