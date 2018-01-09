package com.niit.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class IndexController {
	@RequestMapping("/index")  
    public ModelAndView index(){  
        return new ModelAndView("index");  
    } 
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage() {

		return new ModelAndView("loginPage");
	}
}