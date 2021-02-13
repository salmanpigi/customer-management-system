package com.enigma.api.inventory.models.search;

import com.enigma.api.inventory.models.pagginations.PageSearch;
import com.enigma.api.inventory.models.validations.Alphabetic;

public class TransactionStatusSearch extends PageSearch {
    @Alphabetic
    private String status;
}
