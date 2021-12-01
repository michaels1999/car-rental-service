package io.angelwing.service;

import io.angelwing.model.IncomeCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IncomeCategoryService {

    void addIncomeCategory(IncomeCategory incomeCategory);

    void updateIncomeCategory(IncomeCategory incomeCategory);

    void removeIncomeCategory(UUID id);

    Optional<IncomeCategory> getIncomeCategoryById(UUID id);

    List<IncomeCategory> listIncomeCategory();
}
