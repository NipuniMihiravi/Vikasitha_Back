package com.example.demo.Repository;

import com.example.demo.Model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    List<Expense> findByExpenseName(String expenseName);
    List<Expense> findByDateBetween(LocalDate start, LocalDate end);
    List<Expense> findByExpenseNameAndDateBetween(String expenseName, LocalDate start, LocalDate end);
}
