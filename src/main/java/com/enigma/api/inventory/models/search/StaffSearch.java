package com.enigma.api.inventory.models.search;

import com.enigma.api.inventory.models.pagginations.PageSearch;
import com.enigma.api.inventory.models.validations.Alphabetic;

import java.math.BigInteger;

public class StaffSearch extends PageSearch {

    @Alphabetic
    private String name;

    private BigInteger idCard;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getIdCard() {
        return idCard;
    }

    public void setIdCard(BigInteger idCard) {
        this.idCard = idCard;
    }
}
