package io.angelwing.car.rental.service.exception;

public class ReservationNotFoundException extends CarRentalServiceException {

    public ReservationNotFoundException() {
        super(ErrorCode.CRS004);
    }
}
