package com.enigma.api.inventory.services;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.entities.summaries.CustomerSummary;

import java.util.List;

public interface CustomerService extends CommonService<Customer, Integer> {

    public List<CustomerSummary> findAllSummaries();
}
