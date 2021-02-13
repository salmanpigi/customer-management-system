package com.enigma.api.inventory.repositories.summaries;

import com.enigma.api.inventory.entities.summaries.TransactionSummary;

import java.util.List;

public interface TransactionSummaryRepository {

    public List<TransactionSummary> findAllSummaries();

}
