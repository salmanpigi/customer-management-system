package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.repositories.summaries.CustomerSummaryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>, CustomerSummaryRepository {

    @Query(value = "select * from customer where name = :name", nativeQuery = true)
    List<Customer> getCustomerByName(String name);
    //aaaaaa
}
