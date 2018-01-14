package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Categories;
import com.niit.shoppingcart.model.Users;

@ Repository("usersDao")
@Transactional
public class UserDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	public boolean addUsers(Users users) {
		
		try{
			Session session = getSession();

					session.save(users);  ///  insert into table 

					session.flush();

					session.close();
					
					return true;
				}
					catch(HibernateException e)
					{ 
					return false;
					}
	}

	public Users getUsersById(String userId) {
		// TODO Auto-generated method stub
		Session session = getSession();
		return (Users) session.get(Users.class, userId);
	}
	public List<Users> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Users");
		List<Users> customerList = query.list();

		return customerList;

	}
	public Users getUsersByUsername(String userName) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Users where username = ?");
		query.setString(0, userName);

		return (Users) query.uniqueResult();

	}
	public boolean updateUsers(Users users) {
		
		try{		// TODO Auto-generated method stub
			Session session = getSession();

					session.update(users);

					session.flush();

					session.close();
					return true;
					}catch(HibernateException e)
			           {
						return false;
					}
	}
		
	
	public boolean deleteUsers(String userId) {
		try{
			Session session = getSession();

			Query query = session.createQuery("from Users where userId = ?");
			query.setString(0, userId);

			Users u=(Users) query.uniqueResult();
			session.delete(u);
			session.flush();

			session.close();
			return true;
			}
			catch(HibernateException e)
			{
				return false;
				}
	}
}
