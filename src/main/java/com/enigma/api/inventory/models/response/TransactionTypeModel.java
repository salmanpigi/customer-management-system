package com.enigma.api.inventory.models.response;

import com.enigma.api.inventory.models.validations.Alphabetic;

import javax.validation.constraints.Size;

public class TransactionTypeModel {

    private Integer id;

    @Alphabetic
    @Size(min = 1, max = 100)
    private String trxType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrxType() {
        return trxType;
    }

    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }
}
