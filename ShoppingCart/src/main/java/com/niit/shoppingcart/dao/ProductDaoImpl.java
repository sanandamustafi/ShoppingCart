package com.niit.shoppingcart.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public Boolean insertProduct(Product product) {
		// TODO Auto-generated method stub
		try{
			Session session = getSession();
		
		session.save(product);  ///  insert into table 

		session.flush();

		session.close();
		return true;
	}catch(HibernateException e)
		{
		return false;
		}
	}

	public List<Product> retreive() {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<Product> list= session.createQuery("From Product where productStatus='true'").list();
		session.close();
		return list;
	}

	public Product FindByProductID(int productId) {
		// TODO Auto-generated method stub
		Session session= getSession();
		Query query = session.createQuery("from Product where productId = :productId");
		query.setParameter("productId", productId);
		Product product = (Product)query.uniqueResult();
		session.close();
		return product;
	}

	public List<Product> FindByCategoryId(int categoryId) {
		// TODO Auto-generated method stub
		Session session= getSession();
		Query query = session.createQuery("from Product where productcategories.categoryId = :categoryId  and productStatus = 'true'" );
		query.setParameter("categoryId", categoryId);
		List<Product> productList = query.list();
        session.close();
        System.out.println("list "+productList);
		return productList;
	}
	public Boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
Session session = getSession();
		
		try
		{
			session.update(product);
			session.flush();
			session.close();
			return true;
		}
		catch(HibernateException e)
		{
			return false;	
		}
	}
	
	public Boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
Session session = getSession();
		
		try
		{
			session.save(product);
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
	


