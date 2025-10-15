package com.example.demo.Service;

import com.example.demo.Model.Expense;
import com.example.demo.Repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    // ✅ Get all expenses
    public List<Expense> getAll() {
        return repo.findAll();
    }

    // ✅ Get expense by ID
    public Optional<Expense> getById(String id) {
        return repo.findById(id);
    }

    // ✅ Add new expense
    public Expense add(Expense expense) {
        return repo.save(expense);
    }

    // ✅ Update existing expense
    public Expense updateExpense(String id, Expense updatedExpense) {
        return repo.findById(id)
                .map(existing -> {
                    existing.setExpenseName(updatedExpense.getExpenseName());
                    existing.setAmount(updatedExpense.getAmount());
                    existing.setDate(updatedExpense.getDate());
                    existing.setDescription(updatedExpense.getDescription());
                    return repo.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Expense not found with ID: " + id));
    }

    // ✅ Delete expense
    public void delete(String id) {
        repo.deleteById(id);
    }

    // ✅ Filter expenses by expense name, date range, or both
    public List<Expense> filter(String expenseName, LocalDate startDate, LocalDate endDate) {
        List<Expense> all = repo.findAll();

        return all.stream()
                .filter(e -> (expenseName == null || e.getExpenseName().equalsIgnoreCase(expenseName)))
                .filter(e -> (startDate == null || !e.getDate().isBefore(startDate)))
                .filter(e -> (endDate == null || !e.getDate().isAfter(endDate)))
                .collect(Collectors.toList());
    }
}
