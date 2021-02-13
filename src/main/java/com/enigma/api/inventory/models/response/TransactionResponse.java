package com.enigma.api.inventory.models.response;

public class TransactionResponse {

    private Integer id;

    private Long amount;

    private TransactionTypeModel transactionType;

    private CustomerResponse customer;

    private TransactionStatusModel transactionStatus;

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

    public TransactionTypeModel getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeModel transactionType) {
        this.transactionType = transactionType;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponse customer) {
        this.customer = customer;
    }

    public TransactionStatusModel getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatusModel transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
