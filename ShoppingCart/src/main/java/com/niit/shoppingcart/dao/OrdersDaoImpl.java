package com.niit.shoppingcart.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Orders;
import com.niit.shoppingcart.model.Users;

@Repository("orderDao")
@Transactional
public class OrdersDaoImpl implements OrdersDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public Boolean insertOrder(Orders orders) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
		
		session.save(orders);  ///  insert into table 
		
		
		session.flush();
		session.close();
		return true;
		}
	catch(HibernateException e)
		{
		e.printStackTrace();
		return false;
		}
		
			
	}
	
	public Boolean updateOrder(Orders orders) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
		
		session.update(orders);  ///  insert into table 
		session.flush();
		session.close();
		return true;
	}catch(HibernateException e)
		{
		return false;
		}
	}
	public List<Orders> TrackOrderListByUser(Users users) {
		// TODO Auto-generated method stub
		try{Session session=getSession();
			Query query=session.createQuery("from Orders where users.userId=:userId");
			query.setParameter("userId", users.getUserId());
			session.flush();
	        session.close();
			return query.list();
			
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
	}
	public Orders TrackOrderByOrderId(int orders) {
		// TODO Auto-generated method stub
		
		try{Session session=getSession();
			Query query=session.createQuery("from Orders where orderId = ?");
			query.setInteger(0, orders);
			session.flush();
	        session.close();
			return (Orders) query.uniqueResult();
			
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
	}
	public Boolean deleteOrder(Orders orders) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
		
		session.delete(orders);  ///  insert into table 
		session.flush();
		session.close();
		return true;
	}catch(HibernateException e)
		{
		return false;
		}
	}
}


