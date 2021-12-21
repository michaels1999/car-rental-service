package io.angelwing.car.rental.service.service;

public interface AuthorizationService {

    String authorize(final String provider, String code);

}
