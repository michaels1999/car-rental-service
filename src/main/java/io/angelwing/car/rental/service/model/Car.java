package io.angelwing.car.rental.service.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @Column(name = "car_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_make_id")
    private CarMake carMake;

    @Enumerated(EnumType.STRING)
    private Color color;

    @Column(name = "regular_price")
    private Double regularPrice;

    @Column(name = "young_price")
    private Double youngPrice;

    @Column(name = "elder_price")
    private Double elderPrice;

    @Column(name = "inexperienced_price")
    private Double inexperiencedPrice;

    public Car() {
        // NOOP
    }

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

    public void setId(UUID id) {
        this.id = id;
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
