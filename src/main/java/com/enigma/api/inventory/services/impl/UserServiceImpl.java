package com.enigma.api.inventory.services.impl;

import com.enigma.api.inventory.entities.User;
import com.enigma.api.inventory.repositories.UserRepository;
import com.enigma.api.inventory.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends CommonServiceImpl<User, Integer> implements UserService {

    @Autowired
    protected UserServiceImpl(UserRepository repository) {
        super(repository);
    }
}
