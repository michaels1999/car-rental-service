package io.angelwing.car.rental.service.generator;

import io.angelwing.car.rental.service.model.BodyType;
import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.model.CombustionType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static io.angelwing.car.rental.service.generator.CarBrandGenerator.generateRandomCarBrand;

public final class CarMakeGenerator {

    private CarMakeGenerator() {
        // NOOP
    }

    public static CarMake generateRandomCarMake() {
        return generateRandomCarMake((UUID) null);
    }

    public static CarMake generateRandomCarMake(final CarBrand carBrand) {
        return generateRandomCarMake(null, carBrand);
    }

    public static CarMake generateRandomCarMake(final CarBrand carBrand, final BodyType bodyType) {
        return generateRandomCarMake(null, carBrand, bodyType);
    }

    public static CarMake generateRandomCarMake(final UUID id) {
        return generateRandomCarMake(id, generateRandomCarBrand(UUID.randomUUID()));
    }

    private static CarMake generateRandomCarMake(final UUID id, final CarBrand carBrand) {
        return generateRandomCarMake(id, carBrand, BodyType.SEDAN);
    }

    private static CarMake generateRandomCarMake(final UUID id, CarBrand carBrand, BodyType bodyType) {
        return CarMake.builder()
                .withId(id)
                .withCarBrand(carBrand)
                .withName("A4")
                .withYear(2015)
                .withEngineVolume(2.0)
                .withBodyType(bodyType)
                .withCombustionType(CombustionType.GAS)
                .build();
    }

    public static Collection<CarMake> generateRandomCarMakes(final int numberOfCarMakes) {
        final Collection<CarMake> carMakes = new ArrayList<>();

        for (int i = 0; i < numberOfCarMakes; i++) {
            carMakes.add(generateRandomCarMake(UUID.randomUUID()));
        }
        return carMakes;
    }
}
