package com.fusemachine.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fusemachine.inventory.domain.Customer;
import com.fusemachine.inventory.repository.CustomerRepository;

@Controller
@RequestMapping(value = "/rest2/customers")
public class CustomerRestApiController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@RequestMapping
	public List<Customer> get() {
		return this.customerRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Customer insert(@RequestBody Customer product) {
		return this.customerRepository.save(product);
	}
	
	
}
