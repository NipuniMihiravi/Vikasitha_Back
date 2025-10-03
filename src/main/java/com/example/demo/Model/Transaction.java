package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "transactions")
public class Transaction {

    @Id
    private String id;

    private String memberId;
    private LocalDate date;
    private String description;
    private double debit;
    private double credit;
    private double balance;
    private double lateFee;

    // 🔹 Extra Bill Info
    private String billNo;   // ✅ add this

    private double meterReadingThisMonth;
    private double meterReadingRemain;
    private double monthUnit;
    private double unit;
    private double fixCharge;
    public Transaction() {}

    public Transaction(double lateFee) {
        this.lateFee = lateFee;
    }

    public Transaction(String id, String memberId, LocalDate date, String description, double debit, double credit, double balance, String billNo, double meterReadingThisMonth, double meterReadingRemain, double monthUnit, double unit, double fixCharge) {
        this.id = id;
        this.memberId = memberId;
        this.date = date;
        this.description = description;
        this.debit = debit;
        this.credit = credit;
        this.balance = balance;
        this.billNo = billNo;
        this.meterReadingThisMonth = meterReadingThisMonth;
        this.meterReadingRemain = meterReadingRemain;
        this.monthUnit = monthUnit;
        this.unit = unit;
        this.fixCharge = fixCharge;
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

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public double getMeterReadingThisMonth() {
        return meterReadingThisMonth;
    }

    public void setMeterReadingThisMonth(double meterReadingThisMonth) {
        this.meterReadingThisMonth = meterReadingThisMonth;
    }

    public double getMeterReadingRemain() {
        return meterReadingRemain;
    }

    public void setMeterReadingRemain(double meterReadingRemain) {
        this.meterReadingRemain = meterReadingRemain;
    }

    public double getMonthUnit() {
        return monthUnit;
    }

    public void setMonthUnit(double monthUnit) {
        this.monthUnit = monthUnit;
    }

    public double getUnit() {
        return unit;
    }

    public void setUnit(double unit) {
        this.unit = unit;
    }

    public double getFixCharge() {
        return fixCharge;
    }

    public void setFixCharge(double fixCharge) {
        this.fixCharge = fixCharge;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }
}
