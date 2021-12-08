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

    public VinCode(String id, Car car, Boolean available) {
        this.id = id;
        this.car = car;
        this.available = available;
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
}
