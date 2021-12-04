package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.Reservation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ReservationRepositoryImpl implements ReservationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Reservation> findAll() {
        return entityManager.createQuery("from Reservation", Reservation.class).getResultList();
    }

    @Override
    public Optional<Reservation> findById(final UUID id) {
        return Optional.ofNullable(entityManager.find(Reservation.class, id));
    }

    @Override
    @Transactional
    public Reservation save(final Reservation reservation) {
        entityManager.persist(reservation);
        entityManager.flush();
        entityManager.refresh(reservation);
        return reservation;
    }
}
