package io.angelwing.car.rental.service.util;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ClearDatabaseRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void clear() {
        entityManager.createQuery("delete from Reservation").executeUpdate();
        entityManager.createQuery("delete from User").executeUpdate();
        entityManager.createQuery("delete from VinCode").executeUpdate();
        entityManager.createQuery("delete from Car").executeUpdate();
        entityManager.createQuery("delete from CarMake").executeUpdate();
        entityManager.createQuery("delete from CarBrand").executeUpdate();
    }
}
