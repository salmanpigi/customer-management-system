package com.enigma.api.inventory.entities.summaries;

import com.enigma.api.inventory.entities.AccountType;
import com.enigma.api.inventory.entities.User;

import java.math.BigInteger;

public class CustomerSummary {

    private Integer id;
    private BigInteger noAccount;
    private BigInteger idCard;
    private String name;
    private String gender;
    private String address;
    private String phoneNumber;
    private Long balance;
    private User user;
    private AccountType accountType;

    public CustomerSummary(Integer id, BigInteger noAccount, BigInteger idCard, String name, String gender,
                           String address, String phoneNumber, Long balance, User user, AccountType accountType) {
        this.id = id;
        this.noAccount = noAccount;
        this.idCard = idCard;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.user = user;
        this.accountType = accountType;
    }

    public CustomerSummary() {

    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
