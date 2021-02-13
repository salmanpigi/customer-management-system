package com.enigma.api.inventory.repositories;

import com.enigma.api.inventory.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Integer> {
}
