package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDao;
import com.niit.shoppingcart.dao.UsersDao;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Users;

@Controller
public class UserController {
	@Autowired
	UsersDao usersDao;
	@Autowired
	  CartDao cartDao;
	
	/*@RequestMapping("/usersform")  
    public ModelAndView showform(){  
        return new ModelAndView("usersform","command",new Users());  
    } 
	@RequestMapping(value="/save",method = RequestMethod.POST)  
    public ModelAndView save(@ModelAttribute("users") Users users){  
    	usersDao.addUsers(users);
    	
        return new ModelAndView("redirect:/viewusers");//will redirect to viewusers request mapping  
    }  
	@RequestMapping("/viewusers")  
    public ModelAndView viewusers(){  
        List<Users> list=usersDao.getAllUsers();
        return new ModelAndView("viewusers","list",list);  
    }  
	
	@RequestMapping(value="/editusers/{id}")  
    public ModelAndView edit(@PathVariable String id){  
        Users users=usersDao.getUsersById(id);  
        return new ModelAndView("userseditform","command",users);  
    }  
	@RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public ModelAndView editsave(@ModelAttribute("users") Users users){  
    	usersDao.updateUsers(users);
        return new ModelAndView("redirect:/viewusers");  
    }  
	@RequestMapping(value="/deleteusers/{id}",method = RequestMethod.GET)  
    public ModelAndView delete(@PathVariable String id){ 
    	System.out.println("delete is called");
       usersDao.deleteUsers(id);
        return new ModelAndView("redirect:/viewusers");  
    }  */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView userRegistrationView(){
    	return new
    			ModelAndView("userregistrationview", "command",new Users());
    }
    
    
    /* user Registration*/
    
    @RequestMapping(value="/registerUser",method=RequestMethod.POST)
    public ModelAndView registerUser(@ModelAttribute("User")Users users,HttpSession httpSession){
    	ModelAndView modelAndView=new ModelAndView("userRegistrationView","command",new Users());
    	if(usersDao.getUsersById(users.getUserId())!=null){
    		System.out.println("at same user Id");
    		modelAndView.addObject("errorMessage","Please try with diffrent user Id.");
    		return modelAndView;
    	}else{
    		users.setEnabled(true);
    		users.setRole("ROLE_USER");
    		Cart cart=new Cart();
    		
    		if(cartDao.insertCart(cart)){
    			users.setCart(cart);
    			if(usersDao.addUsers(users)){
    				modelAndView.addObject("successMessage","You have been registered sucessfully.");
    				return modelAndView;
    			}else{
    				
    				modelAndView.addObject("errorMessage","User has not been inserted!");
    				return modelAndView;
    			}
    			}else{
    				modelAndView.addObject("errorMessage","Cart has not been inserted!");
    				return modelAndView;
    			}
    			
    			}
    			
    			
    		}
    		
    	
    }

