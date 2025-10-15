package com.example.demo.Controller;

import com.example.demo.Model.ExpenseName;
import com.example.demo.Service.ExpenseNameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-names")
@CrossOrigin
public class ExpenseNameController {

    private final ExpenseNameService service;

    public ExpenseNameController(ExpenseNameService service) {
        this.service = service;
    }

    @GetMapping
    public List<ExpenseName> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ExpenseName add(@RequestBody ExpenseName expenseName) {
        return service.add(expenseName);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
