package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.VinCode;

import java.util.Collection;
import java.util.Optional;

public interface VinCodeRepository {

    Collection<VinCode> findAll();

    Optional<VinCode> findById(String id);

    VinCode save(VinCode vinCode);
}
