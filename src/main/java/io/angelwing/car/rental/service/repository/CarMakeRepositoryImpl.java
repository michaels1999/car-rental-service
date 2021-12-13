package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.CarMake;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CarMakeRepositoryImpl implements CarMakeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<CarMake> findAll() {
        return entityManager.createQuery("from CarMake", CarMake.class).getResultList();
    }

    @Override
    public Optional<CarMake> findById(final UUID id) {
        return Optional.ofNullable(entityManager.find(CarMake.class, id));
    }

    @Override
    @Transactional
    public CarMake save(final CarMake carMake) {
        entityManager.persist(carMake);
        entityManager.flush();
        entityManager.refresh(carMake);
        return carMake;
    }

}
