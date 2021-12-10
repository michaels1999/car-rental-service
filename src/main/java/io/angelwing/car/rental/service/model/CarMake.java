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
@Table(name = "car_make")
public class CarMake {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "car_make_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    private String name;

    private Integer year;

    @Column(name = "engine_volume")
    private Double engineVolume;

    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    private BodyType bodyType;

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
