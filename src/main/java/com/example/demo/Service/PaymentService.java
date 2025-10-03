package com.example.demo.Service;

import com.example.demo.Model.Payment;
import com.example.demo.Repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public List<Payment> getAllPayments() {
        return repository.findAll();
    }
    public List<Payment> getPaymentsByMemberId(String memberId) {
        return repository.findByMemberId(memberId);
    }

    public Optional<Payment> getPaymentById(String id) {
        return repository.findById(id);
    }

    public Payment createPayment(Payment payment) {
        return repository.save(payment);
    }

    public Payment updatePayment(String id, Payment updatedPayment) {
        return repository.findById(id)
                .map(payment -> {
                    payment.setMemberId(updatedPayment.getMemberId());
                    payment.setName(updatedPayment.getName());
                    payment.setPaymentDate(updatedPayment.getPaymentDate());
                    payment.setPayment(updatedPayment.getPayment());
                    return repository.save(payment);
                })
                .orElseThrow(() -> new RuntimeException("Payment not found with id: " + id));
    }

    public void deletePayment(String id) {
        repository.deleteById(id);
    }
}
