package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.Car;
import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.model.VinCode;
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
import static io.angelwing.car.rental.service.generator.VinCodeGenerator.generateRandomVinCode;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class VinCodeRepositoryTest {

    @Autowired
    private VinCodeRepository vinCodeRepository;

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
    void shouldFindVinCodeById() {
        final VinCode expectedVinCode = prepareVinCode();

        final Optional<VinCode> actualVinCode = vinCodeRepository.findById(expectedVinCode.getId());

        assertThat(actualVinCode)
                .usingRecursiveComparison()
                .isEqualTo(Optional.of(expectedVinCode));
    }

    @Test
    void shouldFindAllVinCodes() {
        final Collection<VinCode> expectedVinCodes = prepareVinCodes(5);

        final Collection<VinCode> actualVinCodes = vinCodeRepository.findAll();

        assertThat(actualVinCodes)
                .usingRecursiveComparison()
                .isEqualTo(expectedVinCodes);
    }

    private Collection<VinCode> prepareVinCodes(final int numberOfVinCodes) {
        final Collection<VinCode> expectedVinCodes = new ArrayList<>();

        IntStream.rangeClosed(1, numberOfVinCodes)
                .forEach(i -> expectedVinCodes.add(prepareVinCode()));

        return expectedVinCodes;
    }

    private VinCode prepareVinCode() {
        final CarBrand carBrand = carBrandRepository.save(generateRandomCarBrand());
        final CarMake carMake = carMakeRepository.save(generateRandomCarMake(carBrand));
        final Car car = carRepository.save(generateRandomCar(carMake));

        return vinCodeRepository.save(generateRandomVinCode(car));
    }

}