package io.angelwing.car.rental.service.repository;

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
import static io.angelwing.car.rental.service.generator.CarMakeGenerator.generateRandomCarMake;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarMakeRepositoryTest {

    @Autowired
    CarMakeRepository carMakeRepository;

    @Autowired
    CarBrandRepository carBrandRepository;

    @Autowired
    ClearDatabaseRepository clearDatabaseRepository;

    @AfterEach
    void tearDown() {
        clearDatabaseRepository.clear();
    }


    @Test
    void shouldFindCarMakeById() {
        final CarMake expectedCarMake = prepareCarMake();

        final Optional<CarMake> actualCarMake = carMakeRepository.findById(expectedCarMake.getId());

        assertThat(actualCarMake)
                .usingRecursiveComparison()
                .isEqualTo(Optional.of(expectedCarMake));
    }

    @Test
    void shouldFindAllCarMake() {
        final Collection<CarMake> expectedCarMakes = prepareCarMakes(5);

        Collection<CarMake> actualCarMakes = carMakeRepository.findAll();

        assertThat(actualCarMakes)
                .usingRecursiveComparison()
                .isEqualTo(expectedCarMakes);

    }

    private Collection<CarMake> prepareCarMakes(final int numberOfCars) {
        final Collection<CarMake> expectedCars = new ArrayList<>();

        IntStream.rangeClosed(1, numberOfCars)
                .forEach(i -> expectedCars.add(prepareCarMake()));

        return expectedCars;
    }

    private CarMake prepareCarMake() {
        final CarBrand carBrand = carBrandRepository.save(generateRandomCarBrand());

        return carMakeRepository.save(generateRandomCarMake(carBrand));
    }

}