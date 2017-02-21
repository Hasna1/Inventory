package com.fusemachine.inventory.domain;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String productName,category,costPrice,sellingPrice;
	private Integer quantity;
	
	private Boolean status;
	
	
	public Product() {
		super();
	}


	public Product( String productName, String category,
			String costPrice, String sellingPrice, Integer quantity,
			 Boolean status) {
		super();
		//this.id = id;
		this.productName = productName;
		this.category = category;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
		
		this.status = status;
	}

	@Column(name="product_id")
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	@NotNull
	@Column(name="product_name")
	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	@NotNull
	@Column(name="category")
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

	@NotNull
	@Column(name="cost_price")
	public String getCostPrice() {
		return costPrice;
	}


	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	@NotNull
	@Column(name="selling_price")
	public String getSellingPrice() {
		return sellingPrice;
	}


	public void setSellingPrice(String sellingPrice) {
		this.sellingPrice = sellingPrice;
	}


	@NotNull
	@Column(name="quantity")
	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}




	@NotNull
	@Column(name="status")
	public Boolean getStatus() {
		return status;
	}


	public void setStatus(Boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName
				+ ", category=" + category + ", costPrice=" + costPrice
				+ ", sellingPrice=" + sellingPrice + ", quantity=" + quantity
				+ 
				", status=" + status + "]";
	}
	
	
	

	}