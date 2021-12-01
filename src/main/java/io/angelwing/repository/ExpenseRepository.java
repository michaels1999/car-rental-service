package io.angelwing.repository;

import io.angelwing.model.Expense;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpenseRepository extends CrudRepository<Expense , UUID> {
}
