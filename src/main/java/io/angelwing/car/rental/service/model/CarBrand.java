package io.angelwing.car.rental.service.model;

import java.util.UUID;

public class CarBrand {

    private UUID id;

    private String name;


    public CarBrand(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
