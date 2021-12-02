package io.angelwing.car.rental.service.model;

import java.util.UUID;

public class Car {

    private UUID id;

    private CarMake carMake;

    private Color color;

    private Double regularPrice;

    private Double youngPrice;

    private Double elderPrice;

    private Double inexperiencedPrice;

    public Car(UUID id, CarMake carMake, Color color, Double regularPrice, Double youngPrice, Double elderPrice, Double inexperiencedPrice) {
        this.id = id;
        this.carMake = carMake;
        this.color = color;
        this.regularPrice = regularPrice;
        this.youngPrice = youngPrice;
        this.elderPrice = elderPrice;
        this.inexperiencedPrice = inexperiencedPrice;
    }

    public UUID getId() {
        return id;
    }

    public CarMake getCarMake() {
        return carMake;
    }

    public Color getColor() {
        return color;
    }

    public Double getRegularPrice() {
        return regularPrice;
    }

    public Double getYoungPrice() {
        return youngPrice;
    }

    public Double getElderPrice() {
        return elderPrice;
    }

    public Double getInexperiencedPrice() {
        return inexperiencedPrice;
    }
}
