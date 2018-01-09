package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Users;

@ Repository("cartDao")
@Transactional
public class CartDaoImpl implements CartDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public Boolean insertCart(Cart cart) {
		// TODO Auto-generated method stub
		try{
		Session session = getSession();
		session.save(cart);  ///  insert into table 
		session.flush();
		session.close();
        return true;
	}catch(HibernateException e)
		{
		return false;
		}
	}

	

	public Boolean updateCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
			
			session.update(cart);
			return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		finally{
			session.flush();
			session.close();
		}	
		
	}

	public Boolean deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		Session session=getSession();
		try{
		session.delete(cart);
		return true;
		}catch(HibernateException e){
			e.printStackTrace();
			return false;
		}
		finally{
			session.flush();
			session.close();
		}
	}
	
	
	public Cart getCartByCartId(int cartId) {
		// TODO Auto-generated method stub
		Session session=getSession();
		Query query=session.createQuery("from cart where cartId= ?");
		query.setInteger(0, cartId);
		session.flush();
		session.close();
		return (Cart)query.uniqueResult();
	}
	public Cart getCartByUser(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Cart> getallCart() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Cart");
		List<Cart> cartList = query.list();

		return cartList;

	}

}
