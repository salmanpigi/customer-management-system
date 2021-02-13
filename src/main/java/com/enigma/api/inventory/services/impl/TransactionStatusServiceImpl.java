package com.enigma.api.inventory.services.impl;

import com.enigma.api.inventory.entities.TransactionStatus;
import com.enigma.api.inventory.repositories.TransactionStatusReository;
import com.enigma.api.inventory.services.TransactionStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionStatusServiceImpl extends CommonServiceImpl<TransactionStatus, Integer>
        implements TransactionStatusService {

    @Autowired
    protected TransactionStatusServiceImpl(TransactionStatusReository repository) {
        super(repository);
    }
}
