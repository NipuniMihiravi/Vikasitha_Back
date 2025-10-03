package com.example.demo.Controller;

import com.example.demo.Model.Payment;
import com.example.demo.Service.PaymentService;
import com.example.demo.Service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService service;
    private final TransactionService transactionService;

    public PaymentController(PaymentService service, TransactionService transactionService) {
        this.service = service;
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return service.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable String id) {
        return service.getPaymentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/member/{memberId}")
    public List<Payment> getPaymentsByMemberId(@PathVariable String memberId) {
        return service.getPaymentsByMemberId(memberId);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        Payment savedPayment = service.createPayment(payment);
        transactionService.createTransactionFromPayment(savedPayment); // ✅ no balance param
        return savedPayment;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable String id, @RequestBody Payment payment) {
        try {
            return ResponseEntity.ok(service.updatePayment(id, payment));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable String id) {
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}
