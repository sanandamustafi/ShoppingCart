package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoriesDao;
import com.niit.shoppingcart.model.Categories;

@Controller
public class CategoriesController {
	@Autowired
	CategoriesDao categoriesDao; 
	
	@RequestMapping("/categoriesform")  
    public ModelAndView showform(){  
        return new ModelAndView("categoriesform","command",new Categories());  
    } 
	@RequestMapping(value="/savecategories",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("categories") Categories categories)
	{  
		categoriesDao.insertCategories(categories);
    	
        return new ModelAndView("redirect:/viewcategories");//will redirect to viewusers request mapping  
    }  
	@RequestMapping("/viewcategories")  
    public ModelAndView viewcategories(){  
        List<Categories> list=categoriesDao.getlist();
        return new ModelAndView("viewcategories","list",list);  
    } 
	@RequestMapping(value="/editcategories/{id}")  
    public ModelAndView edit(@PathVariable int id){  
       Categories categories=categoriesDao.getCategoriesById(id);  
        return new ModelAndView("categorieseditform","command",categories);  
    }  
	@RequestMapping(value="/editsavecategories",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("categories") Categories categories){  
    	categoriesDao.updateCategories(categories);
        return new ModelAndView("redirect:/viewcategories");  
    }  
	@RequestMapping(value="/deletecategories/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable int id){ 
    	System.out.println("delete is called");
       categoriesDao.deleteCategories(id);
        return new ModelAndView("redirect:/viewcategories");  
    }  
}
