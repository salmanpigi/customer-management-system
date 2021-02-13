package com.enigma.api.inventory.models.search;

import com.enigma.api.inventory.models.pagginations.PageSearch;
import com.enigma.api.inventory.models.validations.Alphabetic;

public class AccountTypeSearch extends PageSearch {
    @Alphabetic
    private String accType;

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }
}
