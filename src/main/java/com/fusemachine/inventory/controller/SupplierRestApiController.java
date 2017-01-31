package com.fusemachine.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fusemachine.inventory.domain.Customer;
import com.fusemachine.inventory.domain.Supplier;
import com.fusemachine.inventory.repository.SupplierRepository;

@RestController
@RequestMapping(value = "/rest3/suppliers")
public class SupplierRestApiController {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@RequestMapping
	public List<Supplier> get() {
		return this.supplierRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Supplier insert(@RequestBody Supplier product) {
		return this.supplierRepository.save(product);
	}
	
	
}
