package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
