package com.enigma.api.inventory.models.response;

import com.enigma.api.inventory.models.validations.Alphabetic;

import javax.validation.constraints.Size;

public class AccountTypeModel {

    private Integer id;

    @Alphabetic
    @Size(min = 1, max = 100)
    private String accType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }
}
