package com.fusemachine.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fusemachine.inventory.domain.Customer;
import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.repository.CustomerRepository;
import com.fusemachine.inventory.repository.ProductRepository;
import com.fusemachine.inventory.service.ProductService;
import com.fusemachine.inventory.service.impl.ProductServiceJpaImpl;


@Controller
@RequestMapping(value="/customers")
public class CustomerController {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
@RequestMapping
    public String customer(Model model) {
    	model.addAttribute("customer", new Customer());
    	List<Product> productList=new 	ArrayList<Product>();
		//System.out.println("hello");
		model.addAttribute("products",this.productRepository.findAll());
        model.addAttribute("list", productList);

        return "customers";
    }


@RequestMapping(value="/customers")
public String product(Model model) {
	model.addAttribute("customer", new Customer());
    return "customers";
}


	
      @RequestMapping(value="/displaycustomers",method = RequestMethod.POST)
      public String customerSubmit(@ModelAttribute Customer customer) {
        customer = this.customerRepository.save(customer);
 	    return "displaycustomers";
      }

}
