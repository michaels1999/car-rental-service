package io.angelwing.car.rental.service.generator;

import io.angelwing.car.rental.service.model.Car;
import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.model.Color;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static io.angelwing.car.rental.service.generator.CarMakeGenerator.generateRandomCarMake;

public final class CarGenerator {

    private CarGenerator() {
        // NOOP
    }

    public static Car generateRandomCar() {
        return generateRandomCar((UUID) null);
    }

    public static Car generateRandomCar(final CarMake carMake) {
        return generateRandomCar(null, carMake);
    }

    public static Car generateRandomCar(final UUID id) {
        return generateRandomCar(id, generateRandomCarMake(UUID.randomUUID()));
    }

    private static Car generateRandomCar(final UUID id, final CarMake carMake) {
        return Car.builder()
                .withId(id)
                .withCarMake(carMake)
                .withColor(Color.BLACK)
                .withRegularPrice(25.0)
                .withYoungPrice(30.0)
                .withElderPrice(35.0)
                .withInexperiencedPrice(35.0)
                .build();
    }

    public static Collection<Car> generateRandomCars(final int numberOfCars) {
        final Collection<Car> cars = new ArrayList<>();

        for (int i = 0; i < numberOfCars; i++) {
            cars.add(generateRandomCar(UUID.randomUUID()));
        }
        return cars;
    }
}

