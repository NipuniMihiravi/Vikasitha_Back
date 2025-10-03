package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "bills")
public class MemberBilling {

    @Id
    private String id;

    private String billNo;

    private String memberId;
    private LocalDate meterReadingThisMonthDate;
    private double meterReadingThisMonth;
    private double meterReadingRemain;


    private double monthUnit;
    private double unit;
    private double thisMonthCharge;
    private double fixCharge;
    private double thisMonthTotal;

    private String status;
    private String remark;

    // ✅ Default constructor (required by Spring Data)
    public MemberBilling() {
    }

    // ✅ Constructor matching only the fields that exist
    public MemberBilling(String id, String billNo, String memberId,
                         LocalDate meterReadingThisMonthDate, double meterReadingThisMonth,
                         double meterReadingRemain, double monthUnit,
                         double unit, double thisMonthCharge, double fixCharge,
                         double thisMonthTotal, String status, String remark) {
        this.id = id;
        this.billNo = billNo;
        this.memberId = memberId;
        this.meterReadingThisMonthDate = meterReadingThisMonthDate;
        this.meterReadingThisMonth = meterReadingThisMonth;
        this.meterReadingRemain = meterReadingRemain;

        this.monthUnit = monthUnit;
        this.unit = unit;
        this.thisMonthCharge = thisMonthCharge;
        this.fixCharge = fixCharge;
        this.thisMonthTotal = thisMonthTotal;
        this.status = status;
        this.remark = remark;
    }

    // ✅ Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getBillNo() { return billNo; }
    public void setBillNo(String billNo) { this.billNo = billNo; }


    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public LocalDate getMeterReadingThisMonthDate() { return meterReadingThisMonthDate; }
    public void setMeterReadingThisMonthDate(LocalDate meterReadingThisMonthDate) { this.meterReadingThisMonthDate = meterReadingThisMonthDate; }

    public double getMeterReadingThisMonth() { return meterReadingThisMonth; }
    public void setMeterReadingThisMonth(double meterReadingThisMonth) { this.meterReadingThisMonth = meterReadingThisMonth; }

    public double getMeterReadingRemain() { return meterReadingRemain; }
    public void setMeterReadingRemain(double meterReadingRemain) { this.meterReadingRemain = meterReadingRemain; }


    public double getMonthUnit() { return monthUnit; }
    public void setMonthUnit(double monthUnit) { this.monthUnit = monthUnit; }

    public double getUnit() { return unit; }
    public void setUnit(double unit) { this.unit = unit; }

    public double getThisMonthCharge() { return thisMonthCharge; }
    public void setThisMonthCharge(double thisMonthCharge) { this.thisMonthCharge = thisMonthCharge; }

    public double getFixCharge() { return fixCharge; }
    public void setFixCharge(double fixCharge) { this.fixCharge = fixCharge; }

    public double getThisMonthTotal() { return thisMonthTotal; }
    public void setThisMonthTotal(double thisMonthTotal) { this.thisMonthTotal = thisMonthTotal; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
