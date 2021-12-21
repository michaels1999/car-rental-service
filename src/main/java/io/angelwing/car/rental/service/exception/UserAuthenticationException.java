package io.angelwing.car.rental.service.exception;

public class UserAuthenticationException extends CarRentalServiceException {

    public UserAuthenticationException() {
        super(ErrorCode.CRS401);
    }
}
