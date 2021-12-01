package io.angelwing.repository;

import io.angelwing.model.IncomeCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IncomeCategoryRepository extends CrudRepository<IncomeCategory , UUID> {
}
