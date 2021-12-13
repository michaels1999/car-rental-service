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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;

@Entity
@Table(name = "car_make")
public class CarMake {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "car_make_id")
    private UUID id;

    @NotNull(message = "Car brand is missing")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    @NotBlank(message = "Car make name should not be empty")
    private String name;

    @NotNull(message = "Year is missing")
    @Min(value = 1900, message = "Specified year is less than 1900")
    @Max(value = 2021, message = "Specified year is greater than 2021")
    private Integer year;

    @NotNull(message = "Engine volume is missing")
    @Positive(message = "Engine volume could not be less than zero")
    @Max(value = 10, message = "Engine volume is greater than 10")
    @Column(name = "engine_volume")
    private Double engineVolume;

    @NotNull(message = "Body type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    private BodyType bodyType;

    @NotNull(message = "Combustion type is required")
    @Enumerated(EnumType.STRING)
    @Column(name = "combustion_type")
    private CombustionType combustionType;

    public CarMake() {
        // NOOP
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

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID id;

        private CarBrand carBrand;

        private String name;

        private Integer year;

        private Double engineVolume;

        private BodyType bodyType;

        private CombustionType combustionType;

        private Builder() {
            // NOOP
        }

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withCarBrand(CarBrand carBrand) {
            this.carBrand = carBrand;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withYear(Integer year) {
            this.year = year;
            return this;
        }

        public Builder withEngineVolume(Double engineVolume) {
            this.engineVolume = engineVolume;
            return this;
        }

        public Builder withBodyType(BodyType bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public Builder withCombustionType(CombustionType combustionType) {
            this.combustionType = combustionType;
            return this;
        }

        public CarMake build() {
            CarMake carMake = new CarMake();
            carMake.id = id;
            carMake.carBrand = carBrand;
            carMake.name = name;
            carMake.year = year;
            carMake.engineVolume = engineVolume;
            carMake.bodyType = bodyType;
            carMake.combustionType = combustionType;
            return carMake;
        }

    }


}
