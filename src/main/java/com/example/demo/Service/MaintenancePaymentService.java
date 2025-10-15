package com.example.demo.Service;

import com.example.demo.Model.MaintenancePayment;
import com.example.demo.Repository.MaintenancePaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaintenancePaymentService {

    private final MaintenancePaymentRepository maintenancePaymentRepository;

    public MaintenancePaymentService(MaintenancePaymentRepository maintenancePaymentRepository) {
        this.maintenancePaymentRepository = maintenancePaymentRepository;
    }

    // ➕ Add new payment
    public MaintenancePayment addPayment(MaintenancePayment payment) {
        return maintenancePaymentRepository.save(payment);
    }

    // 🔍 Get all payments
    public List<MaintenancePayment> getAllPayments() {
        return maintenancePaymentRepository.findAll();
    }

    // 🔍 Get payments by Maintenance ID
    public List<MaintenancePayment> getPaymentsByMemberId(String memberId) {
        return maintenancePaymentRepository.findByMemberId(memberId);
    }

    // 🔍 Get single payment by ID
    public Optional<MaintenancePayment> getPaymentById(String id) {
        return maintenancePaymentRepository.findById(id);
    }

    public MaintenancePayment updatePayment(String id, MaintenancePayment updatedPayment) {
        Optional<MaintenancePayment> existingPaymentOpt = maintenancePaymentRepository.findById(id);
        if (existingPaymentOpt.isPresent()) {
            MaintenancePayment existingPayment = existingPaymentOpt.get();
            existingPayment.setAmount(updatedPayment.getAmount());
            existingPayment.setDate(updatedPayment.getDate());
            existingPayment.setMemberId(updatedPayment.getMemberId());
            return maintenancePaymentRepository.save(existingPayment);
        } else {
            throw new RuntimeException("Payment not found with id: " + id);
        }
    }

    // 🗑️ Delete payment record
    public void deletePayment(String id) {
        maintenancePaymentRepository.deleteById(id);
    }
}
