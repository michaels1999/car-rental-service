package io.angelwing.car.rental.service.generator;

import io.angelwing.car.rental.service.model.CarBrand;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class CarBrandGenerator {

    private CarBrandGenerator() {
        // NOOP
    }

    public static CarBrand generateRandomCarBrand() {
        return generateRandomCarBrand(null);
    }

    public static CarBrand generateRandomCarBrand(final UUID id) {
        return CarBrand.builder()
                .withId(id)
                .withName("Audi")
                .build();
    }

    public static Collection<CarBrand> generateRandomCarBrands(final int numberOfCarBrands) {
        final Collection<CarBrand> carBrands = new ArrayList<>();

        for (int i = 0; i < numberOfCarBrands; i++) {
            carBrands.add(generateRandomCarBrand());
        }
        return carBrands;
    }

    public static Collection<CarBrand> generateRandomCarBrandsWithIds(final int numberOfCarBrands) {
        final Collection<CarBrand> carBrands = new ArrayList<>();

        for (int i = 0; i < numberOfCarBrands; i++) {
            carBrands.add(generateRandomCarBrand(UUID.randomUUID()));
        }
        return carBrands;
    }
}
