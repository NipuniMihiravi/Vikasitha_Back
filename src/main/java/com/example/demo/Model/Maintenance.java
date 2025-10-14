package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "maintenances")
public class Maintenance {
    @Id
    private String id;

    private String memberId;
    private String memberName;
    private String address;

    private String maintenanceName;
    private double cost;
    private LocalDate date;
    private String description;
    private String doneBy;

    public Maintenance(String id, String memberId, String memberName, String address, String maintenanceName, double cost, LocalDate date, String description, String doneBy) {
        this.id = id;
        this.memberId = memberId;
        this.memberName = memberName;
        this.address = address;
        this.maintenanceName = maintenanceName;
        this.cost = cost;
        this.date = date;
        this.description = description;
        this.doneBy = doneBy;
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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaintenanceName() {
        return maintenanceName;
    }

    public void setMaintenanceName(String maintenanceName) {
        this.maintenanceName = maintenanceName;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

    public String getDoneBy() {
        return doneBy;
    }

    public void setDoneBy(String doneBy) {
        this.doneBy = doneBy;
    }
}
