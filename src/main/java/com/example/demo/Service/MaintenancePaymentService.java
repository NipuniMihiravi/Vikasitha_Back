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
    public List<MaintenancePayment> getPaymentsByMaintenanceId(String maintenanceId) {
        return maintenancePaymentRepository.findByMaintenanceId(maintenanceId);
    }

    // 🔍 Get single payment by ID
    public Optional<MaintenancePayment> getPaymentById(String id) {
        return maintenancePaymentRepository.findById(id);
    }

    // 🗑️ Delete payment record
    public void deletePayment(String id) {
        maintenancePaymentRepository.deleteById(id);
    }
}
