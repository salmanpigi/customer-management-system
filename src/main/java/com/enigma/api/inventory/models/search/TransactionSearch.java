package com.enigma.api.inventory.models.search;

import com.enigma.api.inventory.models.pagginations.PageSearch;

import java.math.BigInteger;

public class TransactionSearch extends PageSearch {

    private BigInteger amount;

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }
}
