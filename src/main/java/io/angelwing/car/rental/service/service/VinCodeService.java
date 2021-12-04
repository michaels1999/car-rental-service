package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.VinCode;

import java.util.Collection;
import java.util.Optional;

public interface VinCodeService {

    Collection<VinCode> findAll();

    Optional<VinCode> findById(String id);

    VinCode save(VinCode vinCode);


}
