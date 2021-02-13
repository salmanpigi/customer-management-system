package com.enigma.api.inventory.services.impl;

import com.enigma.api.inventory.entities.Staff;
import com.enigma.api.inventory.repositories.StaffRepository;
import com.enigma.api.inventory.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl extends CommonServiceImpl<Staff, Integer> implements StaffService {

    @Autowired
    protected StaffServiceImpl(StaffRepository repository) {
        super(repository);
    }
}
