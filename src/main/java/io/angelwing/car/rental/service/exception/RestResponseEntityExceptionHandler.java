package io.angelwing.car.rental.service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CarRentalServiceException.class)
    public ResponseEntity<RestError> handleNotFoundException(final CarRentalServiceException e) {
        final ErrorCode errorCode = e.getCode();
        return new ResponseEntity<>(new RestError(errorCode, Collections.singleton(errorCode.getMessage())), errorCode.getStatus());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<RestError> handleValidationException(final ConstraintViolationException e) {
        final Set<String> violations = e.getConstraintViolations().stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        final ErrorCode errorCode = ErrorCode.CRS555;

        return new ResponseEntity<>(new RestError(errorCode, violations), errorCode.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<RestError> handleUnexpectedException(final Exception exception) {
        final ErrorCode errorCode = ErrorCode.CRS666;

        final Set<String> errors = new HashSet<>();
        errors.add(errorCode.getMessage());
        errors.add(exception.getMessage());

        return new ResponseEntity<>(new RestError(errorCode, errors), errorCode.getStatus());
    }

}
