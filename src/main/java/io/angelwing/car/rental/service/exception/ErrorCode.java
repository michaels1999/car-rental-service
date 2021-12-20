package io.angelwing.car.rental.service.exception;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    CRS001(HttpStatus.NOT_FOUND, "Car not found"),
    CRS002(HttpStatus.NOT_FOUND, "Car brand not found"),
    CRS003(HttpStatus.NOT_FOUND, "Car make not found"),
    CRS004(HttpStatus.NOT_FOUND, "Reservation not found"),
    CRS005(HttpStatus.NOT_FOUND, "Vin code not found"),
    CRS006(HttpStatus.NOT_FOUND, "User not found"),
    CRS555(HttpStatus.BAD_REQUEST, "Invalid request body"),
    CRS666(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected exception occurred. Contact administrator.");

    private final HttpStatus status;
    private final String message;

    ErrorCode(final HttpStatus status, final String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
