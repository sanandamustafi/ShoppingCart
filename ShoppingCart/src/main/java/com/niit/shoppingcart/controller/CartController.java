package com.niit.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.niit.shoppingcart.dao.CartDao;
import com.niit.shoppingcart.dao.CartItemDao;
import com.niit.shoppingcart.dao.OrdersDao;
import com.niit.shoppingcart.dao.ProductDao;
import com.niit.shoppingcart.dao.UsersDao;

@Controller
public class CartController {
	@Autowired
	ProductDao productDao;
	@Autowired
	UsersDao userDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	OrdersDao ordersDao;

}
