package com.fusemachine.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.repository.ProductRepository;

@RestController
@RequestMapping(name = "/rest1/product")
public class RestApiController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping
	public List<Product> get() {
		return this.productRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Product insert(@RequestBody Product product) {
		return this.productRepository.save(product);
	}
	
	
}
