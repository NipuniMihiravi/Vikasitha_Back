package com.example.demo.Repository;

import com.example.demo.Model.ExpenseName;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseNameRepository extends MongoRepository<ExpenseName, String> {
    boolean existsByName(String name);
}
