package io.angelwing.car.rental.service.exception;

public class VinCodeNotFoundException extends CarRentalServiceException {

    public VinCodeNotFoundException() {
        super(ErrorCode.CRS005);
    }
}
