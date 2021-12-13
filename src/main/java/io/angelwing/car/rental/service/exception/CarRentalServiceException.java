package io.angelwing.car.rental.service.exception;

public class CarRentalServiceException extends RuntimeException {

    private final ErrorCode code;

    public CarRentalServiceException(final ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }
}
