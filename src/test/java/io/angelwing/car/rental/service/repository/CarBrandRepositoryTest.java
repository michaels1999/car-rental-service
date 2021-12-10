package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.util.ClearDatabaseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Optional;

import static io.angelwing.car.rental.service.generator.CarBrandGenerator.generateRandomCarBrand;
import static io.angelwing.car.rental.service.generator.CarBrandGenerator.generateRandomCarBrands;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarBrandRepositoryTest {

    @Autowired
    private CarBrandRepository carBrandRepository;

    @Autowired
    private ClearDatabaseRepository clearDatabaseRepository;

    @AfterEach
    void tearDown() {
        clearDatabaseRepository.clear();
    }

    @Test
    void shouldFindCarBrandById() {
        final CarBrand expectedCarBrand = carBrandRepository.save(generateRandomCarBrand());

        final Optional<CarBrand> actualCarBrand = carBrandRepository.findById(expectedCarBrand.getId());

        assertThat(actualCarBrand)
                .usingRecursiveComparison()
                .isEqualTo(Optional.of(expectedCarBrand));
    }

    @Test
    void shouldFindAllCarBrand() {
        final Collection<CarBrand> expectedCarBrands = generateRandomCarBrands(5);
        expectedCarBrands.forEach(carBrandRepository::save);

        final Collection<CarBrand> actualCarBrands = carBrandRepository.findAll();

        assertThat(actualCarBrands)
                .usingRecursiveComparison()
                .isEqualTo(expectedCarBrands);
    }
}