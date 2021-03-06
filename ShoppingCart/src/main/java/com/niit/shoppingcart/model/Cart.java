package com.niit.shoppingcart.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cart {
	@Id
	@GeneratedValue
	private int cartId;
	@OneToMany(mappedBy="cart")
	private List<CartItem> cartItems;
	private double cartTotal;
	private boolean cartStatus;
	public boolean isCartStatus() {
		return cartStatus;
	}
	public void setCartStatus(boolean cartStatus) {
		this.cartStatus = cartStatus;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public double getCartTotal() {
		return cartTotal;
	}
	public void setCartTotal(double cartTotal) {
		this.cartTotal = cartTotal;
	}
	

}
