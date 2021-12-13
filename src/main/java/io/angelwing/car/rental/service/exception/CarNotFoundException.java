package io.angelwing.car.rental.service.exception;

public class CarNotFoundException extends CarRentalServiceException {

    public CarNotFoundException() {
        super(ErrorCode.CRS001);
    }

}
