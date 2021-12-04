package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.BodyType;
import io.angelwing.car.rental.service.model.Car;
import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.model.Color;
import io.angelwing.car.rental.service.model.CombustionType;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryCarRepository implements CarRepository {

    private static final Map<UUID, Car> CARS = new ConcurrentHashMap<>();

    static {
        UUID audiA4Id = UUID.randomUUID();
        CARS.put(audiA4Id,
                new Car(
                        audiA4Id,
                        new CarMake(
                                UUID.randomUUID(),
                                new CarBrand(UUID.randomUUID(), "Audi"),
                                "A4",
                                2015,
                                2.0,
                                BodyType.SEDAN,
                                CombustionType.GAS
                        ),
                        Color.BLACK,
                        25.0,
                        30.0,
                        35.0,
                        35.0
                )
        );

        UUID bmwM4Id = UUID.randomUUID();
        CARS.put(bmwM4Id,
                new Car(
                        bmwM4Id,
                        new CarMake(
                                UUID.randomUUID(),
                                new CarBrand(UUID.randomUUID(), "BMW"),
                                "M4",
                                2013,
                                4.0,
                                BodyType.SEDAN,
                                CombustionType.GAS
                        ),
                        Color.RED,
                        27.0,
                        32.0,
                        37.0,
                        37.0
                )
        );
    }

    @Override
    public Collection<Car> findAll() {
        return CARS.values();
    }

    @Override
    public Optional<Car> findById(UUID id) {
        return Optional.ofNullable(CARS.get(id));
    }

    @Override
    public Car save(Car car) {
        final UUID carId = UUID.randomUUID();

        car.setId(carId);
        CARS.put(carId, car);

        return car;
    }
}
