package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.repository.CarMakeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

import static io.angelwing.car.rental.service.generator.CarMakeGenerator.generateRandomCarMake;
import static io.angelwing.car.rental.service.generator.CarMakeGenerator.generateRandomCarMakes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class CarMakeServiceTest {

    private final CarMakeRepository carMakeRepository = mock(CarMakeRepository.class);

    private final CarMakeService carMakeService = new CarMakeServiceImpl(carMakeRepository);

    @AfterEach
    void afterEach() {
        verifyNoMoreInteractions(carMakeRepository);
    }

    @Test
    void addCarMake() {
        final UUID carMakeId = UUID.randomUUID();
        final CarMake expectedCarMake = generateRandomCarMake(carMakeId);

        when(carMakeRepository.save(expectedCarMake)).thenReturn(expectedCarMake);
        when(carMakeRepository.findById(carMakeId)).thenReturn(Optional.of(expectedCarMake));

        carMakeService.save(expectedCarMake);

        Optional<CarMake> actualCarMake = carMakeService.findById(carMakeId);
        verify(carMakeRepository).save(expectedCarMake);
        verify(carMakeRepository).findById(carMakeId);

        assertThat(actualCarMake).contains(expectedCarMake);
    }

    @Test
    void findAllCarMake() {
        final Collection<CarMake> expectedCarMake = generateRandomCarMakes(5);
        when(carMakeRepository.findAll()).thenReturn(expectedCarMake);

        final Collection<CarMake> actualCarMake = carMakeService.findAll();
        verify(carMakeRepository).findAll();

        assertThat(actualCarMake).isEqualTo(expectedCarMake);
    }

}