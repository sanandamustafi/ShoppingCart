package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDao {
	public Boolean insertProduct(Product product);
	public List<Product>retreive();
	public Product FindByProductID(int productId);
	public List<Product>FindByCategoryId(int categoryId);
	public Boolean updateProduct(Product product);
	public Boolean deleteProduct(Product product);

}
