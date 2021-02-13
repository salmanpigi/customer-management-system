package com.enigma.api.inventory.services.impl;

import com.enigma.api.inventory.entities.TransactionType;
import com.enigma.api.inventory.repositories.TransactionTypeRepository;
import com.enigma.api.inventory.services.TransactionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeServiceImpl extends CommonServiceImpl<TransactionType, Integer> implements TransactionTypeService {

    @Autowired
    protected TransactionTypeServiceImpl(TransactionTypeRepository repository) {
        super(repository);
    }

}
