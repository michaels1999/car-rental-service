package io.angelwing.car.rental.service.model;

public class VinCode {

    private String vinCode;

    private Car car;

    private Boolean available;

    public VinCode(String vinCode, Car car, Boolean available) {
        this.vinCode = vinCode;
        this.car = car;
        this.available = available;
    }

    public String getVinCode() {
        return vinCode;
    }

    public Car getCar() {
        return car;
    }

    public Boolean getAvailable() {
        return available;
    }
}
