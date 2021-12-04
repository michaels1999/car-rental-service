package io.angelwing.car.rental.service.service;

import io.angelwing.car.rental.service.model.VinCode;
import io.angelwing.car.rental.service.repository.VinCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class VinCodeServiceImpl implements VinCodeService {

    private final VinCodeRepository vinCodeRepository;

    @Autowired
    public VinCodeServiceImpl(final VinCodeRepository vinCodeRepository) {
        this.vinCodeRepository = vinCodeRepository;
    }

    @Override
    public Collection<VinCode> findAll() {
        return vinCodeRepository.findAll();
    }

    @Override
    public Optional<VinCode> findById(final String id) {
        return vinCodeRepository.findById(id);
    }

    @Override
    public VinCode save(final VinCode vinCode) {
        return vinCodeRepository.save(vinCode);
    }
}
