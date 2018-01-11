package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.CartItem;
import com.niit.shoppingcart.model.Orders;

public interface CartItemDao {
	public boolean insertCartItem(CartItem cartItem);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public List<CartItem> getAllCartItem();
	public List<CartItem> getCartItemsByCart(Cart cart);
	public CartItem getCartItemByCartItemId(int cartItemnId);
	public List<CartItem> getCartItemsByOrderDetails(Orders orders);
}
