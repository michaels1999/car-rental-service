package io.angelwing.service;

import io.angelwing.model.Expense;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseService {

    void addExpense(Expense expense);

    void updateExpense(Expense expense);

    void removeExpense(UUID id);

    Optional<Expense> getExpenseById(UUID id);

    List<Expense> listExpense();



}
