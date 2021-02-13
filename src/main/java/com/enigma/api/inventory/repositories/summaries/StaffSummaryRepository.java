package com.enigma.api.inventory.repositories.summaries;

import com.enigma.api.inventory.entities.summaries.StaffSummary;

import java.util.List;

public interface StaffSummaryRepository {

    List<StaffSummary> findAllSummaries();

}
