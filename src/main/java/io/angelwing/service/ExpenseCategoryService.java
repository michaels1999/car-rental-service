package io.angelwing.service;

import io.angelwing.model.ExpenseCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExpenseCategoryService {

    void addExpenseCategory(ExpenseCategory expenseCategory);

    void updateExpenseCategory(ExpenseCategory expenseCategory);

    void removeExpenseCategory(UUID id);

    Optional<ExpenseCategory> getExpenseCategoryById(UUID id);

    List<ExpenseCategory> listExpenseCategory();
}
