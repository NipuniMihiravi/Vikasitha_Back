package com.example.demo.Service;

import com.example.demo.Model.ExpenseName;
import com.example.demo.Repository.ExpenseNameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseNameService {

    private final ExpenseNameRepository repository;

    public ExpenseNameService(ExpenseNameRepository repository) {
        this.repository = repository;
    }

    public List<ExpenseName> getAll() {
        return repository.findAll();
    }

    public ExpenseName add(ExpenseName expenseName) {
        if(repository.existsByName(expenseName.getName())){
            throw new RuntimeException("Expense Name already exists");
        }
        return repository.save(expenseName);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}
