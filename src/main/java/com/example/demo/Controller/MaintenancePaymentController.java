package com.example.demo.Controller;

import com.example.demo.Model.MaintenancePayment;
import com.example.demo.Service.MaintenancePaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/maintenance-payments")
@CrossOrigin(origins = "*")
public class MaintenancePaymentController {

    private final MaintenancePaymentService maintenancePaymentService;

    // ✅ Use constructor injection
    public MaintenancePaymentController(MaintenancePaymentService maintenancePaymentService) {
        this.maintenancePaymentService = maintenancePaymentService;
    }

    // ➕ Add new payment
    @PostMapping
    public MaintenancePayment addPayment(@RequestBody MaintenancePayment payment) {
        return maintenancePaymentService.addPayment(payment);
    }

    // 🔍 Get all payments
    @GetMapping
    public List<MaintenancePayment> getAllPayments() {
        return maintenancePaymentService.getAllPayments();
    }

    // ✅ Get all payments for a specific maintenance record
    @GetMapping("/maintenance/{maintenanceId}")
    public List<MaintenancePayment> getPaymentsByMaintenanceId(@PathVariable String maintenanceId) {
        return maintenancePaymentService.getPaymentsByMaintenanceId(maintenanceId);
    }

    // 🔍 Get single payment
    @GetMapping("/{id}")
    public Optional<MaintenancePayment> getPaymentById(@PathVariable String id) {
        return maintenancePaymentService.getPaymentById(id);
    }

    // 🗑️ Delete payment
    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable String id) {
        maintenancePaymentService.deletePayment(id);
        return "Maintenance payment deleted successfully!";
    }
}
