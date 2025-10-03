package com.example.demo.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "registrations")
public class Registration {

    @Id
    private String id;

    private String memberId;
    private String name;
    private String address;
    private String phoneNumber;
    private String landNo;
    private LocalDate joinDate;
    private LocalDate endDate;
    private String nationalId;
    private String status;
    private String remark;

    // Getters & Setters
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getLandNo() {
        return landNo;
    }
    public void setLandNo(String landNo) {
        this.landNo = landNo;
    }
    public LocalDate getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    public String getNationalId() {
        return nationalId;
    }
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
}
