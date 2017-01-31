package com.fusemachine.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fusemachine.inventory.domain.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Integer>  {
	List<Customer> findByFirstName(String firstName);

}
