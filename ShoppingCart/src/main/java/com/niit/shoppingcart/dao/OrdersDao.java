package com.niit.shoppingcart.dao;





import java.util.List;

import com.niit.shoppingcart.model.Orders;
import com.niit.shoppingcart.model.Users;

public interface OrdersDao {
	public Boolean insertOrder(Orders orders);
	public Boolean updateOrder(Orders orders);
	public Boolean deleteOrder(Orders orders);
	public List<Orders> TrackOrderListByUser (Users users);
	public Orders TrackOrderByOrderId(int orders);
}
