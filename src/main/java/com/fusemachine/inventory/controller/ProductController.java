
package com.fusemachine.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.repository.ProductRepository;
import com.fusemachine.inventory.service.ProductService;
//import com.fusemachine.inventory.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductService productService;
		
	int pageNumber=1;
	
	@RequestMapping(value ="/",method = RequestMethod.GET)
	 public  String LoginPage(){
	    
       return "login";

			}
	@RequestMapping(value="/", method=RequestMethod.POST)
	public String PostLogin(){
		
		return "home";
	}
	
	@RequestMapping(value="/displayproduct",method = RequestMethod.GET)
	public String getProducts(@RequestParam (required = false, value = "page", defaultValue = "1") Integer page,
			@RequestParam (required = false, value = "size",defaultValue = "5") Integer size, Model model){				
		Page<Product> productList = this.productService.findAllProducts(page-1, size);
		model.addAttribute("product",productList.getContent());
		model.addAttribute("totalPage", productList.getTotalPages());
		model.addAttribute("currentPage", productList.getNumber());

		model.addAttribute("url", "/displayproduct");
		return "productdisplay";
	}
	
    @RequestMapping(value="/products")
    public String product(Model model) {
    	model.addAttribute("product", new Product());
        return "products";
    }
/*    
    @RequestMapping(value="displayproduct")
    public String displayproduct(ModelMap map){
    	map.addAttribute("product",productRepository.findAll());
    	return "productdisplay";
    	
    }*/
    @RequestMapping(value = "/displayproduct/search", method = RequestMethod.GET)
	public String getSearchData(@RequestParam (required = false, value = "page", defaultValue = "1") Integer page,@RequestParam (required = false, value = "size",defaultValue = "5") Integer size,@RequestParam(required = false, value = "key", defaultValue =  "") String search, Model model){
	 Page<Product> productinfo = this.productService.getSearchProducts(search.trim(), page-1, size);
	 model.addAttribute("product", productinfo.getContent());
	 model.addAttribute("totalPage", productinfo.getTotalPages());
	 model.addAttribute("url", "/displayproduct/search");
	 return "productdisplay";
	}
    
    @RequestMapping(value="/products",method = RequestMethod.POST)
    public String productSubmit(@ModelAttribute Product product) {
        product = this.productRepository.save(product);
    	return "productdisplay";
    }
    
    @RequestMapping("/updateproduct/{id}")
    public String view(@PathVariable("id") String id, Model model) {
    	Product product = productService.findById(Integer.parseInt(id));
        model.addAttribute("product", product);
        return "updateproduct";
    }

    
    @RequestMapping(value="/updateproduct",method = RequestMethod.POST)
    public String productUpdate(@ModelAttribute Product product) {
        product = this.productRepository.save(product);
    	return "productdisplay";
    }
    
    @RequestMapping(value="/deleteproduct/{id}",method = RequestMethod.DELETE)
    public String productDelete(@PathVariable Integer id) {
    	productService.deleteById(id);
    	
    	return "productdisplay";
    }
    
    
}


