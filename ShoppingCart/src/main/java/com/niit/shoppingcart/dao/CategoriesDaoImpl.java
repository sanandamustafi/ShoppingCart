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



@ Repository("categoriesDao")
@Transactional
public class CategoriesDaoImpl implements CategoriesDao{
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}
	
	public Boolean insertCategories(Categories categories) {
		// TODO Auto-generated method stub
		try{
Session session = getSession();

		session.save(categories);  ///  insert into table 

		session.flush();

		session.close();
		
		return true;
	}
		catch(HibernateException e)
		{ 
		return false;
		}
	}
	public Categories getCategoriesById(int categoryId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Categories where categoryId = ?");
		query.setInteger(0, categoryId);

		return (Categories) query.uniqueResult();

	}
	public List<Categories> getlist() {
		Session session = getSession();

		Query query = session.createQuery("from Categories");
		List<Categories> categoryList = query.list();

		return categoryList;
		
	}
	public Boolean updateCategories(Categories categories) {
try{		// TODO Auto-generated method stub
Session session = getSession();

		session.update(categories);

		session.flush();

		session.close();
		return true;
		}catch(HibernateException e)
           {
			return false;
		}
			}
	public Boolean deleteCategories(int categoryId) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();

			Query query = session.createQuery("from Categories where categoryId = ?");
			query.setInteger(0, categoryId);

			Categories u=(Categories) query.uniqueResult();
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
	
	public List<Categories> ByProductId(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
