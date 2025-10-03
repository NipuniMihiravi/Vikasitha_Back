package com.example.demo.Controller;

import com.example.demo.Model.Transaction;
import com.example.demo.Service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "*")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // ✅ Get all transactions for a member
    @GetMapping("/member/{memberId}")
    public List<Transaction> getTransactionsByMemberId(@PathVariable String memberId) {
        return transactionService.getByMemberId(memberId);
    }
}
