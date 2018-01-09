package com.niit.shoppingcart.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoriesDao;
import com.niit.shoppingcart.dao.ProductDao;
import com.niit.shoppingcart.model.Categories;
import com.niit.shoppingcart.model.Product;



public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoriesDao categoriesDao;

	@RequestMapping("/addProducts")
	public ModelAndView add(HttpSession session) {

		List<Categories> categoryList = categoriesDao.getlist();
		session.setAttribute("categoryList", categoryList);
		ModelAndView mv = new ModelAndView("addProducts", "command", new Product());
		mv.addObject("categoryList", categoryList);

		return mv;
	}

	@RequestMapping(value = "/saveProduct", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("product") Product product, HttpServletRequest request,
			@RequestParam("file") MultipartFile file , HttpSession session) {

		byte fileBytes[];
		FileOutputStream fos = null;

		String fileName = "";
		String productImage = "";
		ServletContext context = request.getServletContext();
		String realContextPath = context.getRealPath("/");
		String pn = product.getProductName();
		if (file != null) {
			fileName = realContextPath + "/resources/img/" + pn + ".jpg";
			productImage = "resources/img/" + pn + ".jpg";
			File fileobj = new File(fileName);
			try {
				fos = new FileOutputStream(fileobj);
				fileBytes = file.getBytes();
				fos.write(fileBytes);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		product.setProductImage(productImage);
		product.setProductStatus(true);	
		ModelAndView mv=new ModelAndView("redirect:/viewProducts");
		if(productDao.insertProduct(product))
		{
			
			session.setAttribute("sucessMessage", "Product added successfully");
			return mv;
		}
		else
		{
			session.setAttribute("sucessMessage", "Product could not be added!!!!");
			return mv;
		}
		 
	}
	@RequestMapping("/viewProducts")
	public ModelAndView view(HttpSession session ) {
		
		List<Product> list = productDao.retreive();
		session.setAttribute("list", list);
		return new ModelAndView("viewProducts", "list", list);
	}
	@RequestMapping(value = "/discontinueProduct/{productId}", method = RequestMethod.GET)
	public ModelAndView deactivateProduct(@PathVariable int productId, HttpSession httpSession) {
		ModelAndView modelAndView = new ModelAndView("redirect:/viewProducts", "command", new Product());
		Product product = productDao.FindByProductID(productId);
		product.setProductStatus(false);
		if (productDao.updateProduct(product)) {
			httpSession.setAttribute("sucessMessage", "product deactivated sucessfully");

		} else {
			httpSession.setAttribute("sucessMessage", "Product Could not be Deactivated!!!!");

		}

		return modelAndView;
	}
	@RequestMapping("/showProductsByCategory/{categoryId}")
	public ModelAndView showProductsByCategory(@PathVariable int categoryId) {
		System.out.println("cat id " + categoryId);
		ModelAndView mv = new ModelAndView("products");
		mv.addObject("productList", productDao.FindByCategoryId(categoryId));
		return mv;
	}
	@RequestMapping("/showProduct/{productId}")
	public ModelAndView showProduct(@PathVariable int productId) {

		ModelAndView mv = new ModelAndView("product");
		mv.addObject("product", productDao.FindByProductID(productId));
		return mv;
	}
}
