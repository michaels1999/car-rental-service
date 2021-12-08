package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.Car;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Car> findAll() {
        return entityManager.createQuery("from Car", Car.class).getResultList();
    }

    @Override
    public Optional<Car> findById(UUID id) {
        return Optional.ofNullable(entityManager.find(Car.class, id));
    }

    @Override
    @Transactional
    public Car save(Car car) {
        entityManager.persist(car);
        entityManager.flush();
        entityManager.refresh(car);
        return car;
    }
}
