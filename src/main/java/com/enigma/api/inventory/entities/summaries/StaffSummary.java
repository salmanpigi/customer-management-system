package com.enigma.api.inventory.entities.summaries;

import com.enigma.api.inventory.entities.User;

import java.math.BigInteger;

public class StaffSummary {

    private Integer id;
    private BigInteger idCard;
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private String role;
    private String division;
    private User user;

    public StaffSummary(Integer id, BigInteger idCard, String name, String gender, String address, String phoneNumber,
                        String role, String division, User user) {
        this.id = id;
        this.idCard = idCard;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.division = division;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigInteger getIdCard() {
        return idCard;
    }

    public void setIdCard(BigInteger idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
