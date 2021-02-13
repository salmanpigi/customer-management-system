package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {
	
	User findByUsername(String username);
	
}