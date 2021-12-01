package io.angelwing.repository;

import io.angelwing.model.ExpenseCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpenseCategoryRepository extends CrudRepository<ExpenseCategory , UUID> {
}
