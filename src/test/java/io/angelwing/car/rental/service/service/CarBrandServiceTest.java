package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.repository.CarBrandRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static io.angelwing.car.rental.service.generator.CarBrandGenerator.generateRandomCarBrand;
import static io.angelwing.car.rental.service.generator.CarBrandGenerator.generateRandomCarBrandsWithIds;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class CarBrandServiceTest {

    private final CarBrandRepository carBrandRepository = mock(CarBrandRepository.class);

    private final CarBrandService carBrandService = new CarBrandServiceImpl(carBrandRepository);


    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(carBrandRepository);
    }

    @Test
    void addCarBrand() {
        final UUID carBrandId = UUID.randomUUID();
        final CarBrand expectedCarBrand = generateRandomCarBrand(carBrandId);

        when(carBrandRepository.save(expectedCarBrand)).thenReturn(expectedCarBrand);
        when(carBrandRepository.findById(carBrandId)).thenReturn(Optional.of(expectedCarBrand));

        carBrandService.save(expectedCarBrand);

        Optional<CarBrand> actualCarBrand = carBrandService.findById(carBrandId);
        verify(carBrandRepository).save(expectedCarBrand);
        verify(carBrandRepository).findById(carBrandId);

        assertThat(actualCarBrand).contains(expectedCarBrand);
    }

    @Test
    void findAllCarBrand() {
        final Collection<CarBrand> expectedCarBrand = generateRandomCarBrandsWithIds(5);
        when(carBrandRepository.findAll()).thenReturn(expectedCarBrand);

        final Collection<CarBrand> actualCarBrand = carBrandService.findAll();
        verify(carBrandRepository).findAll();

        assertThat(actualCarBrand).isEqualTo(expectedCarBrand);
    }

}