package io.angelwing.service;

import io.angelwing.model.Income;
import io.angelwing.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;

    @Autowired
    public IncomeServiceImpl(IncomeRepository incomeRepository) {
        this.incomeRepository = incomeRepository;
    }

    @Override
    @Transactional
    public void addIncome(Income income) {
        this.incomeRepository.save(income);

    }

    @Override
    @Transactional
    public void updateIncome(Income income) {
        this.incomeRepository.save(income);

    }

    @Override
    @Transactional
    public void removeIncome(UUID id) {
        this.incomeRepository.deleteById(id);
    }

    @Override
    public Optional<Income> getIncomeById(UUID id) {
        return incomeRepository.findById(id);
    }

    @Override
    public List<Income> listIncome() {
        return StreamSupport.stream(incomeRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
