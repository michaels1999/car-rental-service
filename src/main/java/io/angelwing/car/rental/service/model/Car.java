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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @Column(name = "car_id")
    private UUID id;

    @NotNull(message = "Car make is missing")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_make_id")
    private CarMake carMake;

    @NotNull(message = "Color is missing")
    @Enumerated(EnumType.STRING)
    private Color color;

    @NotNull(message = "Regular price is missing")
    @Positive(message = "Regular price should be greater than zero")
    @Column(name = "regular_price")
    private Double regularPrice;


    @NotNull(message = "Young price is missing")
    @Positive(message = "Young price should be greater than zero")
    @Column(name = "young_price")
    private Double youngPrice;


    @NotNull(message = "Elder price is missing")
    @Positive(message = "Elder price should be greater than zero")
    @Column(name = "elder_price")
    private Double elderPrice;

    @NotNull(message = "Inexperienced price is missing")
    @Positive(message = "Inexperienced price should be greater than zero")
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

        public Builder withElderPrice(Double elderPrice) {
            this.elderPrice = elderPrice;
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
