package com.niit.shoppingcart.model;

import java.io.Serializable;


import javax.persistence.Entity;

import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Users implements Serializable {
	
	@Id
	private String userId;
	@NotEmpty(message = "Please enter User Name")
	private String userName;
	@NotEmpty(message = "Please enter Password")

	private String userAddress;
	private String userEmail;
	private String userPhone;
	private boolean enabled;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Users(){
	}
	}


