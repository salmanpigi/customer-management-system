package com.enigma.api.inventory.entities.summaries;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.entities.TransactionStatus;
import com.enigma.api.inventory.entities.TransactionType;

public class TransactionSummary {

    private Integer id;
    private Long amount;
    private Customer customer;
    private TransactionType transactionType;
    private TransactionStatus transactionStatus;

    public TransactionSummary(Integer id, Long amount, Customer customer, TransactionType transactionType,
                              TransactionStatus transactionStatus) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
        this.transactionType = transactionType;
        this.transactionStatus = transactionStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
