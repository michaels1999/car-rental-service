package io.angelwing.car.rental.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "vin_code")
public class VinCode {

    @Id
    @Column(name = "vin_code_id")
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;

    @Column(columnDefinition = "TINYINT")
    private Boolean available;

    public VinCode() {
        // NOOP
    }

    public String getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public Boolean getAvailable() {
        return available;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;
        private Car car;
        private Boolean available;

        private Builder() {
            // NOOP
        }

        public Builder withId(String id) {
            this.id = id;
            return this;
        }

        public Builder withCar(Car car) {
            this.car = car;
            return this;
        }

        public Builder withAvailable(Boolean available) {
            this.available = available;
            return this;
        }

        public VinCode build() {
            VinCode vinCode = new VinCode();
            vinCode.id = id;
            vinCode.car = car;
            vinCode.available = available;
            return vinCode;
        }
    }
}
