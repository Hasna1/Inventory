package com.fusemachine.inventory.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fusemachine.inventory.domain.Product;

public interface ProductService {
	List<Product> findAll();
	public Page<Product> findAllProducts(Integer page, Integer size);
	public Page<Product> getSearchProducts(String name, Integer page, Integer size);
//	Page<Product> listAllByPage(Pageable pageable);

    Product findById(Integer id);
    Product insert(Product product);
    Product edit(Product product);
    void deleteById(Integer id);	
}


