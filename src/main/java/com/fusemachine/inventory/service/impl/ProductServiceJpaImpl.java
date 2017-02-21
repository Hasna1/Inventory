package com.fusemachine.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.repository.ProductRepository;
import com.fusemachine.inventory.service.ProductService;


@Service
@Primary
public class ProductServiceJpaImpl implements ProductService{

	@Autowired
	ProductRepository productrepository;
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		
		
		return this.productrepository.findAll();
	}

	@Override
	public Product findById(Integer id) {
		// TODO Auto-generated method stub
		return this.productrepository.findOne(id);
	}

	@Override
	public Product insert(Product product) {
		// TODO Auto-generated method stub
		
		return this.productrepository.save(product);

	}

	@Override
	public Product edit(Product product) {
		
		return this.productrepository.save(product);
		}



	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		this.productrepository.delete(id);
	}

	@Override
	public Page<Product> findAllProducts(Integer page, Integer size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		return this.productrepository.findAll(pageable);

	}

	@Override
	public Page<Product> getSearchProducts(String name, Integer page,
			Integer size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		return this.productrepository.findByProductNameLikeIgnoreCase(name, pageable);

	}


}
