package io.angelwing.service;

import io.angelwing.model.ExpenseCategory;
import io.angelwing.repository.ExpenseCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;

    @Autowired
    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseCategoryRepository = expenseCategoryRepository;
    }


    @Override
    @Transactional
    public void addExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    @Transactional
    public void updateExpenseCategory(ExpenseCategory expenseCategory) {
        this.expenseCategoryRepository.save(expenseCategory);
    }

    @Override
    @Transactional
    public void removeExpenseCategory(UUID id) {
        this.expenseCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<ExpenseCategory> getExpenseCategoryById(UUID id) {
        return expenseCategoryRepository.findById(id);
    }

    @Override
    public List<ExpenseCategory> listExpenseCategory() {
        return StreamSupport.stream(expenseCategoryRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
