package io.angelwing.car.rental.service.exception;

public class UserNotFoundException extends CarRentalServiceException {

    public UserNotFoundException() {
        super(ErrorCode.CRS006);
    }
}
