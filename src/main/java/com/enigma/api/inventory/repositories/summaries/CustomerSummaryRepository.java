package com.enigma.api.inventory.repositories.summaries;

import com.enigma.api.inventory.entities.summaries.CustomerSummary;

import java.util.List;

public interface CustomerSummaryRepository {

    List<CustomerSummary> findAllSummaries();

}
