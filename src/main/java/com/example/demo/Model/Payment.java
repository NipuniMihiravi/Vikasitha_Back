package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "payments")
public class Payment {

    @Id
    private String id;

    private String memberId;
    private String name;
    private LocalDate paymentDate;
    private double payment;

    public Payment() {}

    public Payment(String id, String memberId, String name, LocalDate paymentDate, double payment) {
        this.id = id;
        this.memberId = memberId;
        this.name = name;
        this.paymentDate = paymentDate;
        this.payment = payment;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDate getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDate paymentDate) { this.paymentDate = paymentDate; }

    public double getPayment() { return payment; }
    public void setPayment(double payment) { this.payment = payment; }
}
