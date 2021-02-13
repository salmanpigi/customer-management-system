package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionStatusReository extends JpaRepository<TransactionStatus, Integer> {
}
