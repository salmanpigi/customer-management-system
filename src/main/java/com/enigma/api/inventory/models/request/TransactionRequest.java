package com.enigma.api.inventory.models.request;

public class TransactionRequest {

    private Long amount;
    private Integer transactionTypeId;
    private Integer customerId;
    private Integer transactionStatusId;

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getTransactionTypeId() {
        return transactionTypeId;
    }

    public void setTransactionTypeId(Integer transactionTypeId) {
        this.transactionTypeId = transactionTypeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getTransactionStatusId() {
        return transactionStatusId;
    }

    public void setTransactionStatusId(Integer transactionStatusId) {
        this.transactionStatusId = transactionStatusId;
    }
}
