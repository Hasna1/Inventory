package com.fusemachine.inventory.repository;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fusemachine.inventory.domain.Product;


public interface ProductRepository extends JpaRepository<Product,Integer> {
	List<Product> findByProductName(String productName);
	
	public Page<Product> findByProductName(String productName, Pageable pageable);
	public Page<Product> findByProductNameLikeIgnoreCase(String productName, Pageable pageable);



	
}
