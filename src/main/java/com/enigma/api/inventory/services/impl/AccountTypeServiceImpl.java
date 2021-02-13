package com.enigma.api.inventory.services.impl;

import com.enigma.api.inventory.entities.AccountType;
import com.enigma.api.inventory.repositories.AccountTypeRepository;
import com.enigma.api.inventory.services.AccountTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTypeServiceImpl extends CommonServiceImpl<AccountType, Integer> implements AccountTypeService {

    @Autowired
    protected AccountTypeServiceImpl(AccountTypeRepository repository) {
        super(repository);
    }

}