package com.enigma.api.inventory.models.response;

import com.enigma.api.inventory.models.validations.Alphabetic;

import javax.validation.constraints.Size;
import java.math.BigInteger;

public class StaffResponse {

    private Integer id;
    private BigInteger idCard;

    @Alphabetic
    @Size(min = 1, max = 100)
    private String name;

    @Alphabetic
    @Size(min = 1, max = 10)
    private String gender;

    private String address;
    private String phoneNumber;
    private String role;
    private String division;
    private UserResponse user;

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

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }
}
