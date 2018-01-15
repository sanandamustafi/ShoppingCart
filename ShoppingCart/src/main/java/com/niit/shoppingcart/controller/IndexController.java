package com.niit.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoriesDao;
import com.niit.shoppingcart.dao.ProductDao;
@Controller
public class IndexController {
	@Autowired 
	  CategoriesDao categoriesDao;
	 @Autowired 
	 ProductDao productDao;
	@RequestMapping("/index")  
    public ModelAndView index(){  
        return new ModelAndView("index");  
    } 
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage() {

		return new ModelAndView("loginPage");
	}
	 @RequestMapping(value = "/403", method = RequestMethod.GET)
		public ModelAndView noAccess() {

			return new ModelAndView("403");
		}
	 @RequestMapping("/home")  
	    public ModelAndView index(HttpSession session){  
		 ModelAndView mv= new ModelAndView("home");
		 session.setAttribute("categoryList", categoriesDao.getlist());
		 mv.addObject("categoryList", categoriesDao.getlist());
	        return mv;  
	    } 
}
