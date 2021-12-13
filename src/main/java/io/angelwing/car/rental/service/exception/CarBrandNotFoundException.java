package io.angelwing.car.rental.service.exception;

public class CarBrandNotFoundException extends CarRentalServiceException {

    public CarBrandNotFoundException() {
        super(ErrorCode.CRS002);
    }

}
