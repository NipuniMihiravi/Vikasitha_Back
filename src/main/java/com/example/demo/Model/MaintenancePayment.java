package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "maintenance_payments")
public class MaintenancePayment {
    @Id
    private String id;

    private String memberId; // link to Maintenance
    private double amount;
    private LocalDate date;

    public MaintenancePayment(String id, String memberId, double amount, LocalDate date) {
        this.id = id;
        this.memberId = memberId;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String maintenanceId) {
        this.memberId = maintenanceId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
