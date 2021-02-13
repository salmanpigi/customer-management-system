package com.enigma.api.inventory.models.request;

import com.enigma.api.inventory.models.validations.Alphabetic;

import java.math.BigInteger;

public class CustomerRequest {

    private BigInteger noAccount;
    private BigInteger idCard;

    @Alphabetic
    private String name;

    private String gender;
    private String address;
    private String phoneNumber;
    private Long balance;
    private Integer accountTypeId;
    private Integer UserId;

    public BigInteger getNoAccount() {
        return noAccount;
    }

    public void setNoAccount(BigInteger noAccount) {
        this.noAccount = noAccount;
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

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }
}
