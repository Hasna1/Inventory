package com.fusemachine.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fusemachine.inventory.domain.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
	List<Supplier> findByFirstName(String firstName);
}
