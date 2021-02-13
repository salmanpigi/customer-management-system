package com.enigma.api.inventory.repositories.summaries;

import com.enigma.api.inventory.entities.Customer;
import com.enigma.api.inventory.entities.summaries.CustomerSummary;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CustomerSummaryRepositoryImpl implements CustomerSummaryRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<CustomerSummary> findAllSummaries() {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerSummary> criteria = builder.createQuery(CustomerSummary.class);
        Root<Customer> root = criteria.from(Customer.class);

        criteria.multiselect(root.get("item"), root.get("user"), root.get("accountType"));

        return entityManager.createQuery(criteria).getResultList();
    }
}
