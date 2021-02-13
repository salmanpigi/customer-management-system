package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.AccountType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
}
