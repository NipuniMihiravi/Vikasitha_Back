package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "tariff")
public class Tariff {

    @Id
    private String id;

    private LocalDate tariffDate;
    private String tariffName;

    private Integer minUnit; // minimum unit of this range
    private Integer maxUnit; // maximum unit of this range
    private Double unitPrice;
    private Double fixCharge;
    private String remark;
    private String status; // ACTIVE/INACTIVE



    public Tariff() {}

    public Tariff(LocalDate tariffDate, String tariffName, Integer minUnit, Integer maxUnit,
                  Double unitPrice, Double fixCharge, String remark, String status) {
        this.tariffDate = tariffDate;
        this.tariffName = tariffName;
        this.minUnit = minUnit;
        this.maxUnit = maxUnit;
        this.unitPrice = unitPrice;
        this.fixCharge = fixCharge;
        this.remark = remark;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getTariffDate() {
        return tariffDate;
    }

    public void setTariffDate(LocalDate tariffDate) {
        this.tariffDate = tariffDate;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public Integer getMinUnit() {
        return minUnit;
    }

    public void setMinUnit(Integer minUnit) {
        this.minUnit = minUnit;
    }

    public Integer getMaxUnit() {
        return maxUnit;
    }

    public void setMaxUnit(Integer maxUnit) {
        this.maxUnit = maxUnit;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getFixCharge() {
        return fixCharge;
    }

    public void setFixCharge(Double fixCharge) {
        this.fixCharge = fixCharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}
