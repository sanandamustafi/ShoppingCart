package com.niit.shoppingcart.dao;


import java.util.List;


import com.niit.shoppingcart.model.Categories;
import com.niit.shoppingcart.model.Product;




public interface CategoriesDao {
	public Boolean insertCategories(Categories categories);
	public List<Categories> getlist();
	public Categories getCategoriesById(int categoryId);
	
	public Boolean updateCategories(Categories categories);
	public Boolean deleteCategories(int categoryId);


}
