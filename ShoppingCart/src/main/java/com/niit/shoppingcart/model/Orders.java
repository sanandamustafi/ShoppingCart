package com.niit.shoppingcart.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Orders {
	@Id
	@GeneratedValue
	private int orderId;
	
	private String OrderStatus;
	@OneToMany(mappedBy="orders")
	List<CartItem> cartItems;
	private Date orders;
	@ManyToOne
	@JoinColumn(name="userId")
	Users users;
	private String orderAddress;
	private int orderPin;
	private double orderTotal;
	

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	public Date getOrders() {
		return orders;
	}
	public void setOrders(Date orders) {
		this.orders = orders;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public String getOrderAddress() {
		return orderAddress;
	}
	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}
	public int getOrderPin() {
		return orderPin;
	}
	public void setOrderPin(int orderPin) {
		this.orderPin = orderPin;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	}
