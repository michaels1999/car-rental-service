package io.angelwing.car.rental.service.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "car_brand")
public class CarBrand {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "car_brand_id")
    private UUID id;

    private String name;

    public CarBrand() {
        // NOOP
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID id;

        private String name;

        private Builder() {
            // NOOP
        }

        public Builder withId(final UUID id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public CarBrand build() {
            CarBrand carBrand = new CarBrand();
            carBrand.id = id;
            carBrand.name = name;
            return carBrand;
        }
    }
}
