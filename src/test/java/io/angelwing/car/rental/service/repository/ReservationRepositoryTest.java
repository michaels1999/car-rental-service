package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.Car;
import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.model.Reservation;
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
import static io.angelwing.car.rental.service.generator.ReservationGenerator.generateRandomReservation;
import static io.angelwing.car.rental.service.generator.VinCodeGenerator.generateRandomVinCode;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository reservationRepository;

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
    void shouldFindReservationById() {
        final Reservation expectedReservation = prepareReservation();

        final Optional<Reservation> actualReservation = reservationRepository.findById(expectedReservation.getId());

        assertThat(actualReservation)
                .usingRecursiveComparison()
                .isEqualTo(Optional.of(expectedReservation));
    }

    @Test
    void shouldFindAllReservations() {
        final Collection<Reservation> expectedReservations = prepareReservations(5);

        final Collection<Reservation> actualReservations = reservationRepository.findAll();

        assertThat(actualReservations)
                .usingRecursiveComparison()
                .isEqualTo(expectedReservations);
    }

    private Collection<Reservation> prepareReservations(final int numberOfReservations) {
        final Collection<Reservation> expectedReservations = new ArrayList<>();

        IntStream.rangeClosed(1, numberOfReservations)
                .forEach(i -> expectedReservations.add(prepareReservation()));

        return expectedReservations;
    }

    private Reservation prepareReservation() {
        final CarBrand carBrand = carBrandRepository.save(generateRandomCarBrand());
        final CarMake carMake = carMakeRepository.save(generateRandomCarMake(carBrand));
        final Car car = carRepository.save(generateRandomCar(carMake));
        final VinCode vinCode = vinCodeRepository.save(generateRandomVinCode(car));

        return reservationRepository.save(generateRandomReservation(vinCode));
    }


}