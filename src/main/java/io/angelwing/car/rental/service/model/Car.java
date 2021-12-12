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

    private Car(final Builder builder) {
        this.id = builder.id;
        this.carMake = builder.carMake;
        this.color = builder.color;
        this.regularPrice = builder.regularPrice;
        this.youngPrice = builder.youngPrice;
        this.elderPrice = builder.elderPrice;
        this.inexperiencedPrice = builder.inexperiencedPrice;
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private UUID id;

        private CarMake carMake;

        private Color color;

        private Double regularPrice;

        private Double youngPrice;

        private Double elderPrice;

        private Double inexperiencedPrice;

        private Builder() {
            // NOOP
        }

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withCarMake(CarMake carMake) {
            this.carMake = carMake;
            return this;
        }

        public Builder withColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder withRegularPrice(Double regularPrice) {
            this.regularPrice = regularPrice;
            return this;
        }

        public Builder withYoungPrice(Double youngPrice) {
            this.youngPrice = youngPrice;
            return this;
        }

        public Builder withElderPrice(Double youngPrice) {
            this.youngPrice = youngPrice;
            return this;
        }

        public Builder withInexperiencedPrice(Double inexperiencedPrice) {
            this.inexperiencedPrice = inexperiencedPrice;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
