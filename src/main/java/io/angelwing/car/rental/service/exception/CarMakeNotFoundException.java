package io.angelwing.car.rental.service.exception;

public class CarMakeNotFoundException extends CarRentalServiceException {

    public CarMakeNotFoundException() {
        super(ErrorCode.CRS003);
    }
}
