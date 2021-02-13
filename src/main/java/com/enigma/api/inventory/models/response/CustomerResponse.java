package com.enigma.api.inventory.models.response;

import com.enigma.api.inventory.models.validations.Alphabetic;

import javax.validation.constraints.Size;
import java.math.BigInteger;

public class CustomerResponse {

    private Integer id;
    private BigInteger idCard;

    @Alphabetic
    @Size(min = 1, max = 100)
    private String name;

    private String gender;
    private String address;
    private String phoneNumber;
    private BigInteger noAccount;
    private Long balance;

    private UserResponse user;
    private AccountTypeModel accountType;

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

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public AccountTypeModel getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeModel accountType) {
        this.accountType = accountType;
    }
}
