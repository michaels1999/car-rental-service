package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.VinCode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

@Repository
public class VinCodeRepositoryImpl implements VinCodeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<VinCode> findAll() {
        return entityManager.createQuery("from VinCode", VinCode.class).getResultList();
    }

    @Override
    public Optional<VinCode> findById(final String id) {
        return Optional.ofNullable(entityManager.find(VinCode.class, id));
    }

    @Override
    @Transactional
    public VinCode save(final VinCode vinCode) {
        entityManager.persist(vinCode);
        entityManager.flush();
        entityManager.refresh(vinCode);
        return vinCode;
    }
}
