//package com.fusemachine.inventory;
//
//
//
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
//import static org.mockito.Mockito.when;
//
//import com.fusemachine.inventory.domain.Product;
//import com.fusemachine.inventory.service.ProductService;
//import com.fusemachine.inventory.service.impl.ProductServiceJpaImpl;
//
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class ProductTester  {
//	
//	
//	
// 
//	 @Mock
//	 private ProductService productService;
//	 
//	 @InjectMocks
//	 private ProductService productServiceImpl = new ProductServiceJpaImpl();
//	 
//	 @Before
//	 public void initializeMockito(){
//		 MockitoAnnotations.initMocks(this);
//	 }
//	 
//	 @Test
//     public void testInsert(){
//	
//     // Expected objects
//
//	 Product product= new Product(28, "MOMO" , "Food Product" , "600" ,"800" , 9 , true );
//	 
////	 when(mockList.get(0)).thenReturn(productToSave);
////	 Product actual = mockList.get(0);
////	 assertEquals(productToSave, actual);
////	 System.out.println(actual);
//	 
//	
//	System.out.println(""+product);
//
//	 
//	 when(productServiceImpl.insert(new Product(28, "MOMO" , "Food Product" , "600" ,"800" , 9 , true ))).thenReturn(product);	 
//
//	 
//	 
//	 }
//
//
//
//
//
//	
//	
//	
//	 
//	
//	
//	
//
//}

package com.fusemachine.inventory;

import static org.testng.AssertJUnit.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.fusemachine.inventory.domain.Product;
import com.fusemachine.inventory.repository.ProductRepository;
import com.fusemachine.inventory.service.ProductService;
import com.fusemachine.inventory.service.impl.ProductServiceJpaImpl;

@ContextConfiguration
public class ProductTester extends BaseTest {

	private static Logger logger = Logger.getLogger(ProductTester.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductServiceJpaImpl productServiceJpaImpl;

	
	private Product firstProduct;

	// create a new product
		Product productnew = new Product("Bag", "Wearables", "1000", "1500", 10,true);
		int count = 0;

		int getCount() {
			List<Product> allproducts = productServiceJpaImpl.findAll();
			int counter = allproducts.size();
			logger.info("Counte:" + counter);
	
			return counter;
	}
		int sizeCount(){
			Page<Product>  productList = productServiceJpaImpl.findAllProducts(1, 5);
			int counterSize = productList.getSize();
			return counterSize;
			
		}
		
	

	@Test
	public void testinsert() {

		System.out.println("before insert");
		Product product = productServiceJpaImpl.insert(productnew);
		productnew.setId(product.getId());
		System.out.println("after insert and before search");
		Product checkproduct = this.productServiceJpaImpl.findById(productnew.getId());
				
		System.out.println("checkproduct with id" + checkproduct.getId());
		System.out.println("test condition " + checkproduct+ "this is for test");
				
		List<Product> allproducts = productServiceJpaImpl.findAll();
		logger.info("Database size:" + allproducts.size());
		count = allproducts.size();
		System.out.println(getCount());
		assertNotNull(true);
		AssertJUnit.assertEquals(checkproduct.getId(), productnew.getId());
		AssertJUnit.assertEquals(checkproduct.getCostPrice(),
		product.getCostPrice());

	}

	@Test
	public void testfindAll() {

		System.out.println("testing for find all");
		List<Product> allproducts = productServiceJpaImpl.findAll();
		logger.info("Product db size:" + allproducts.size());
		System.out.println("final testing");
		int sdbSize = getCount();
		AssertJUnit.assertEquals(allproducts.size(), sdbSize);
		AssertJUnit.assertNotNull(allproducts);

	}

	@Test
	public void testedit() {

		// create a new product
		Product product1 = new Product("Bag1", "Wearables", "1000", "1500", 10,true);
		productServiceJpaImpl.insert(product1);

		// Assert it was created
		Product productId = productServiceJpaImpl.findById(product1.getId());
		logger.info("Product ide:" + productId);

		// Edit its category
		String newCategory = "Eatables";
		product1.setCategory(newCategory);
		Product editedproduct = productServiceJpaImpl.edit(product1);

		// Assert it updated
		Assert.assertEquals(newCategory, editedproduct.getCategory());
		Assert.assertNotNull(true);

	}

	@Test
	public void testdeleteById() {

		Product product2 = new Product("Bag1", "Wearables", "1000", "1500", 10,true);
		productServiceJpaImpl.insert(product2);
		int prodId = product2.getId();
		logger.info(" Product idd: " + prodId);
		productServiceJpaImpl.deleteById(prodId);
		Product deletedProduct = productServiceJpaImpl.findById(prodId);
		logger.info("product delete successful" + deletedProduct);
		Assert.assertNull(deletedProduct);

	}
	
	@Test
	public void testfindById(){
		
		Product product3 = new Product("Bag2" , "wearables" , "1000" , "1500" , 20 , true);
		productServiceJpaImpl.insert(product3);
		int prodId3 = product3.getId();
		Product findProduct = productServiceJpaImpl.findById(prodId3);
		Assert.assertNotNull(findProduct);
		
	}
	
	@Test
	public void testallproduct(){
		
		Page<Product> productList = productServiceJpaImpl.findAllProducts(1, 5);
		productList.getSize();
		logger.info("size :" + productList.getSize());
		int pageSize = sizeCount();
		
		AssertJUnit.assertEquals(productList.getSize(), pageSize);
		AssertJUnit.assertNotNull(productList);
		
		
	}
	
	@Test
	public void testgetSearchProduct(){
		List<Product> product1=new ArrayList<Product>();
		
		Page<Product> getProduct = productServiceJpaImpl.getSearchProducts("bag1", 1, 5);
		logger.info("Get product:"+getProduct);
		for (Product product : getProduct) {
		logger.info("Inside for:"+product.getProductName());
			
			 product1 = productRepository.findByProductName(product.getProductName());
			 logger.info("Products details:"+product1);
			 Assert.assertEquals(product.getProductName(), "Bag1");
		}
		
		
		
	
	}
	
	@Test
	public void testdata(){
		System.out.println("its a test");
	}
	

}
