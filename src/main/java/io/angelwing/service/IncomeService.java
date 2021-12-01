package io.angelwing.service;

import io.angelwing.model.Income;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IncomeService {

    void addIncome(Income income);

    void updateIncome(Income income);

    void removeIncome(UUID id);

    Optional<Income> getIncomeById(UUID id);

    List<Income> listIncome();
}
