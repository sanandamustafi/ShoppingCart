package com.niit.shoppingcart.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product implements Serializable{
	@Id
	@GeneratedValue
	
	private String productId;
	private String productName;
	private String productDescription;
	private  double price;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	private Categories productcategories;
	@Transient
	private MultipartFile file;
	private String productImage;
	public Categories getProductcategories() {
		return productcategories;
	}
	public void setProductcategories(Categories productcategories) {
		this.productcategories = productcategories;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public boolean productStatus;
	public boolean isProductStatus() {
		return productStatus;
	}
	public void setProductStatus(boolean productStatus) {
		this.productStatus = productStatus;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Categories getCategories() {
		return productcategories;
	}
	public void setCategories(Categories productcategories) {
		this.productcategories = productcategories;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	

}
