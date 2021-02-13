package com.enigma.api.inventory.models.element;

import java.math.BigInteger;

public class CustomerElement {

    private Integer id;
    private BigInteger noAccount;
    private BigInteger idCard;
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private Long balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
