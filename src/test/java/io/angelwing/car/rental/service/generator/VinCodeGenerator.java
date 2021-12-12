package io.angelwing.car.rental.service.generator;

import io.angelwing.car.rental.service.model.Car;
import io.angelwing.car.rental.service.model.VinCode;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import static io.angelwing.car.rental.service.generator.CarGenerator.generateRandomCar;

public final class VinCodeGenerator {

    private VinCodeGenerator() {
        // NOOP
    }

    public static VinCode generateRandomVinCode() {
        return generateRandomVinCode(generateRandomCar(UUID.randomUUID()));
    }

    public static VinCode generateRandomVinCode(final Car car) {
        return VinCode.builder()
                .withId(RandomStringUtils.randomAlphanumeric(17))
                .withCar(car)
                .withAvailable(true)
                .build();
    }

    public static Collection<VinCode> generateRandomVinCodes(final int numberOfVinCodes) {
        final Collection<VinCode> vinCodes = new ArrayList<>();

        for (int i = 0; i < numberOfVinCodes; i++) {
            vinCodes.add(generateRandomVinCode());
        }
        return vinCodes;
    }
}
