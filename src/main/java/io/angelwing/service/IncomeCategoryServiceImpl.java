package io.angelwing.service;

import io.angelwing.model.IncomeCategory;
import io.angelwing.repository.IncomeCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IncomeCategoryServiceImpl implements IncomeCategoryService {

    private final IncomeCategoryRepository incomeCategoryRepository;

    @Autowired
    public IncomeCategoryServiceImpl(IncomeCategoryRepository incomeCategoryRepository) {
        this.incomeCategoryRepository = incomeCategoryRepository;
    }

    @Override
    @Transactional
    public void addIncomeCategory(IncomeCategory incomeCategory) {
        this.incomeCategoryRepository.save(incomeCategory);
    }

    @Override
    @Transactional
    public void updateIncomeCategory(IncomeCategory incomeCategory) {
        this.incomeCategoryRepository.save(incomeCategory);
    }

    @Override
    @Transactional
    public void removeIncomeCategory(UUID id) {
        this.incomeCategoryRepository.deleteById(id);
    }

    @Override
    public Optional<IncomeCategory> getIncomeCategoryById(UUID id) {
        return incomeCategoryRepository.findById(id);
    }

    @Override
    public List<IncomeCategory> listIncomeCategory() {
        return StreamSupport.stream(incomeCategoryRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
