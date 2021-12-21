package io.angelwing.car.rental.service.repository;

import io.angelwing.car.rental.service.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> findByEmail(final String email) {
        return Optional.ofNullable(entityManager.find(User.class, email));
    }

    @Override
    @Transactional
    public User save(final User user) {
        entityManager.persist(user);
        entityManager.flush();
        return user;
    }

    @Override
    public boolean exists(final String email) {
        return this.findByEmail(email).isPresent();
    }
}
