package com.example.demo.Controller;

import com.example.demo.Model.Expense;
import com.example.demo.Service.ExpenseService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
@CrossOrigin
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Expense> getAll() {
        return service.getAll();
    }

    // ✅ Get expense by ID (optional helper endpoint)
    @GetMapping("/{id}")
    public Optional<Expense> getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public Expense add(@RequestBody Expense expense) {
        return service.add(expense);
    }

    // ✅ Update existing expense
    @PutMapping("/{id}")
    public Expense update(@PathVariable String id, @RequestBody Expense expense) {
        Optional<Expense> existingExpense = service.getById(id);
        if (existingExpense.isEmpty()) {
            throw new RuntimeException("Expense not found with ID: " + id);
        }

        Expense updated = existingExpense.get();
        updated.setExpenseName(expense.getExpenseName());
        updated.setAmount(expense.getAmount());
        updated.setDate(expense.getDate());
        updated.setDescription(expense.getDescription());

        return service.add(updated); // reusing same save method
    }



    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

    @GetMapping("/filter")
    public List<Expense> filter(
            @RequestParam(required = false) String expenseName,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ) {
        LocalDate start = startDate != null ? LocalDate.parse(startDate) : null;
        LocalDate end = endDate != null ? LocalDate.parse(endDate) : null;
        return service.filter(expenseName, start, end);
    }
}
