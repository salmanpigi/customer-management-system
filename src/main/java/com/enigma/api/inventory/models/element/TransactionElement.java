package com.enigma.api.inventory.models.element;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.entities.TransactionType;

public class TransactionElement {

    private Integer id;

    private Long amount;

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

}
