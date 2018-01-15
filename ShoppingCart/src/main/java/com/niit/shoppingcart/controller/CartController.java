package com.niit.shoppingcart.controller;

import java.security.Principal;
import java.sql.Date;
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
import com.niit.shoppingcart.dao.CartItemDao;
import com.niit.shoppingcart.dao.OrdersDao;
import com.niit.shoppingcart.dao.ProductDao;
import com.niit.shoppingcart.dao.UsersDao;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.CartItem;
import com.niit.shoppingcart.model.Orders;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Users;

@Controller
public class CartController {
	@Autowired
	ProductDao productDao;
	@Autowired
	UsersDao usersDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	OrdersDao ordersDao;
	
	@RequestMapping("/cartview")
	public ModelAndView cartView(Principal principal, HttpSession httpSession){
	ModelAndView modelAndView=new ModelAndView("cartview","command",new Orders());
	String userId=principal.getName();
	Users users=usersDao.getUsersById(userId);
	
	Cart cart=users.getCart();
	
	
	List<CartItem> cartItems=cartItemDao.getCartItemsByCart(cart);
	System.out.println("cartItem is null"+(cartItems==null));
	httpSession.setAttribute("cartItems", cartItems);
	double total=0;
	
	if(cartItems!=null){
		
		for(CartItem cartItem:cartItems){
			total=cartItem.getCartItemSubTotal();
		}
		cart.setCartTotal(total);
		
		System.out.println("****************cartid"+cart.getCartId());
		
	}
	httpSession.setAttribute("cart", cart);
	return modelAndView;
	}
	@RequestMapping("/addToCart/{productId}")
	public ModelAndView addToCart(@PathVariable int productId, Principal principal, HttpSession httpSession){
		System.out.println("at addToCart");
		ModelAndView modelAndView=new ModelAndView("redirect:/cartview");
		Product product=productDao.FindByProductID(productId);
		String userId=principal.getName();
		Users users=usersDao.getUsersById(userId);
		Cart cart=users.getCart();
		List<CartItem> cartItems=cartItemDao.getCartItemsByCart(cart);
		if(cartItems!=null){
			
			for(CartItem cartItem:cartItems){
				if (cartItem.getProduct().getProductId()==productId){
					int cartItemQuantity=cartItem.getCartItemQuantity()+1;
					double productprice=cartItem.getProduct().getPrice();
					double cartItemSubtotal=cartItem.getCartItemSubTotal()+productprice;
					cartItem.setCartItemQuantity(cartItemQuantity);
					cartItem.setCartItemSubTotal(cartItemSubtotal);
					cartItemDao.updateCartItem(cartItem);
					return modelAndView;
				}
			}
		}else{
			System.out.println("cartItem null ******************** at add product");
		}
		CartItem cartItem=new CartItem();
		cartItem.setProduct(product);
		cartItem.setCart(cart);
		cartItem.setCartItemQuantity(1);
		cartItem.setCartItemSubTotal(product.getPrice());
		cartItem.setCartItemsStatus("N");
		cartItemDao.insertCartItem(cartItem);
		
		return modelAndView;
		
	
	}
	@RequestMapping("/deleteCartItem/{cartItemId}")
	public ModelAndView deleteCartItem(@PathVariable int cartItemId,Principal principal, HttpSession httpSession){
		ModelAndView modelAndView=new ModelAndView("redirect:/cartView");
		CartItem cartItem=cartItemDao.getCartItemByCartItemId(cartItemId);
		Cart cart=cartItem.getCart();
		cart.setCartTotal(cart.getCartTotal()-cartItem.getCartItemSubTotal());
		
		System.out.println("carttotal from delete cart"+cart.getCartTotal());
		cartItemDao.deleteCartItem(cartItem);
		return modelAndView;
	}
	@RequestMapping(value = "/order",method=RequestMethod.GET)
	public ModelAndView orderDetails(){
		return new
				ModelAndView("order","command",new Orders());
	}
	
	
	
	@RequestMapping(value="/addToOrderDetails",method=RequestMethod.POST)
	public ModelAndView
	addToOrderDetails(@ModelAttribute("OrderDetails") Orders orders,Principal principal,HttpSession httpsession){
		Double tot=(Double)
		httpsession.getAttribute("grandTotal");
		//int total=Integer.parseInt(tot);
		System.out.println("at addToOrders");
		ModelAndView modelAndView=new ModelAndView("redirect:/orderDetails");
		Users users=usersDao.getUsersById(principal.getName());
		orders.setUsers(users);
		Date d=new Date(System.currentTimeMillis());
		Cart cart=users.getCart();
		orders.setOrderTotal(tot);
		orders.setOrders(d);
		orders.setOrderStatus("NotConfirmed");
		ordersDao.insertOrder(orders);
		
		
		System.out.println("cartItems are updated");
		cart.setCartTotal(0);
		//cartDao.updateCart(cart);
		ordersDao.updateOrder(orders);
		httpsession.setAttribute("orders", orders);
		
		return modelAndView;
		
	}
	
	
	
}

