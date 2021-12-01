package io.angelwing.service;

import io.angelwing.model.Expense;
import io.angelwing.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExpenseServiceImpl implements ExpenseService {


    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }


    @Override
    @Transactional
    public void addExpense(Expense expense) {
        this.expenseRepository.save(expense);
    }

    @Override
    @Transactional
    public void updateExpense(Expense expense) {
        this.expenseRepository.save(expense);
    }

    @Override
    @Transactional
    public void removeExpense(UUID id) {
        this.expenseRepository.deleteById(id);
    }

    @Override
    public Optional<Expense> getExpenseById(UUID id) {
        return expenseRepository.findById(id);
    }

    @Override
    public List<Expense> listExpense() {
        return StreamSupport.stream(expenseRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
