package com.fusemachine.inventory.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.domain.Supplier;
import com.fusemachine.inventory.repository.ProductRepository;
import com.fusemachine.inventory.repository.SupplierRepository;


@Controller
@RequestMapping(value="/suppliers")
public class SupplierController {
	
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping
    public String supplier(Model model) {
    	model.addAttribute("supplier", new Supplier());
    	List<Product> productList=new 	ArrayList<Product>();
		//System.out.println("hello");
		model.addAttribute("products",this.productRepository.findAll());
        model.addAttribute("list", productList);

        return "suppliers";
    }

	
	@RequestMapping(value="/suppliers")
	public String supplierInsert(Model model) {
	model.addAttribute("supplier", new Supplier());
    return "suppliers";
	}
	
	 
    @RequestMapping(value="/displaysuppliers",method = RequestMethod.POST)
    public String productSubmit(@ModelAttribute Supplier supplier) {
        supplier = this.supplierRepository.save(supplier);
    	return "displaysuppliers";
    }

}
