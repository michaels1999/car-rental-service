package io.angelwing.repository;

import io.angelwing.model.Income;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IncomeRepository extends CrudRepository<Income , UUID> {
}
