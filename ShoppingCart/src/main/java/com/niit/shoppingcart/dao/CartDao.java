package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDao {
	public Boolean insertCart(Cart cart);
	public Cart getCartByCartId(int cartId);
	public Cart getCartByUser(int UserId);
	public List <Cart>getallCart();
	public Boolean updateCart(Cart cart);
	public Boolean deleteCart(Cart cart);
 
}
