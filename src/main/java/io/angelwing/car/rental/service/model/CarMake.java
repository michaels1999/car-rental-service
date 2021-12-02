package io.angelwing.car.rental.service.model;

import java.util.UUID;

public class CarMake {

    private UUID id;

    private CarBrand carBrand;

    private String name;

    private Integer year;

    private Double engineVolume;

    private BodyType bodyType;

    private CombustionType combustionType;

    public CarMake(UUID id, CarBrand carBrand, String name, Integer year, Double engineVolume, BodyType bodyType, CombustionType combustionType) {
        this.id = id;
        this.carBrand = carBrand;
        this.name = name;
        this.year = year;
        this.engineVolume = engineVolume;
        this.bodyType = bodyType;
        this.combustionType = combustionType;
    }

    public UUID getId() {
        return id;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public CombustionType getCombustionType() {
        return combustionType;
    }
}
