package com.niit.shoppingcart.controller;

import org.springframework.stereotype.Controller;


	

	import java.security.Principal;
	import java.util.List;

	import javax.servlet.http.HttpSession;

	import org.springframework.beans.factory.annotation.Autowired;
	
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartItemDao;
import com.niit.shoppingcart.dao.OrdersDao;
import com.niit.shoppingcart.dao.UsersDao;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.CartItem;
import com.niit.shoppingcart.model.Orders;
import com.niit.shoppingcart.model.Users;

	


	@Controller
	public class OrderController {

		@Autowired
		UsersDao usersDao;
		
		
		
		@Autowired
		CartItemDao  cartItemDao;
		
		@Autowired
		OrdersDao  orderDao;
		@RequestMapping("/payment") 
		public ModelAndView payment(Principal principal, HttpSession httpSession){
			
			ModelAndView mv=new ModelAndView("payment");
		
					return mv;
		
	}
		@RequestMapping("/checkout")
		public ModelAndView gotocheckout(Principal principal, HttpSession httpSession) {
			ModelAndView mv=new ModelAndView("checkout");
			return mv;
		}
		
		
		@RequestMapping("/ack")
		public ModelAndView ack(Principal principal, HttpSession httpSession) {
			
			String un=principal.getName();
			Users user=usersDao.getUsersById(un);
			Orders  orders=(Orders)httpSession.getAttribute("orders");
			Cart cart=user.getCart();
			List<CartItem> cartItems=cartItemDao.getCartItemsByCart(cart);
			for(CartItem cartItem:cartItems){
				cartItem.setOrder(orders);
				cartItem.setCartItemsStatus("ORDERED");
				cartItemDao.updateCartItem(cartItem);
			}
			
			orders.setOrderStatus("Confirmed");
			orderDao.updateOrder(orders);
			
			ModelAndView mv=new ModelAndView("ack");
			return mv;
		}
		
		@RequestMapping("/cashpay")
		public ModelAndView cashOnDelivary(Principal principal, HttpSession httpSession) {
			ModelAndView mv=new ModelAndView("cashpay");
			return mv;
		}
		
		@RequestMapping("/orderDetails")
		public ModelAndView orderDetails(Principal principal, HttpSession httpSession) {
			ModelAndView mv=new ModelAndView("orderDetails");
			return mv;
		}
	}
	
