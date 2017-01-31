//package com.fusemachine.inventory.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//import org.springframework.stereotype.Service;
//
//import com.fusemachine.inventory.domain.Product;
//import com.fusemachine.inventory.service.ProductService;
//
//
//@Service
//public class ProductServiceImpl implements ProductService {
// 
//	 private List<Product> products = new ArrayList<Product>();
//	@Override
//	public List<Product> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Product findById(Long id) {
//		// TODO Auto-generated method stub
//		
//		return this.products.stream()
//				 .filter(p -> Objects.equals(p.getId(), id))
//	             .findFirst()
//	             .orElse(null);
//	}
//
//	@Override
//	public Product insert(Product product) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Product edit(Product product) {
//		 for (int i = 0; i < this.products.size(); i++) {
//	            if (Objects.equals(this.products.get(i).getId(), product.getId())) {
//	                this.products.set(i, product);
//	                return product;
//	            }
//	        }
//	        throw new RuntimeException("Post not found: " + product.getId());
//	}
//
//	@Override
//	public void deleteById(Long id) {
//		// TODO Auto-generated method stub
//		  for (int i = 0; i < this.products.size(); i++) {
//	            if (Objects.equals(this.products.get(i).getId(), id)) {
//	                this.products.remove(i);
//	                return;
//	            }
//	        }
//	        throw new RuntimeException("Post not found: " + id);
//	    }
//	}
//
