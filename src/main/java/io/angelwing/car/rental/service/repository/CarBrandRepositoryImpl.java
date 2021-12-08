package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.CarBrand;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CarBrandRepositoryImpl implements CarBrandRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<CarBrand> findAll() {
        return entityManager.createQuery("from CarBrand", CarBrand.class).getResultList();
    }

    @Override
    public Optional<CarBrand> findById(final UUID id) {
        return Optional.ofNullable(entityManager.find(CarBrand.class, id));
    }

    @Override
    @Transactional
    public CarBrand save(final CarBrand carBrand) {
        entityManager.persist(carBrand);
        entityManager.flush();
        return carBrand;
    }
}
