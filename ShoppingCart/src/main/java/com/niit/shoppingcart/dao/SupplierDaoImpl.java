package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Suppliers;


@ Repository("suppliersDao")
@Transactional
public class SupplierDaoImpl implements SuppliersDao {
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	protected Session getSession() {
		return sessionFactory.openSession();
	}

	public Boolean addSuppliers(Suppliers suppliers) {
		// TODO Auto-generated method stub
		try{
		Session session = getSession();

		

		session.save(suppliers);  ///  insert into table 

		session.flush();

		session.close();
		return true;
		}
		catch(HibernateException e)
		{
			return false;
		}
		
	}

	public Suppliers getSupplierById(int supplierId) {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Suppliers where supplierId = ?");
		query.setInteger(0, supplierId);

		return (Suppliers) query.uniqueResult();

	}

	public List<Suppliers> getAllSuppliers() {
		// TODO Auto-generated method stub
		Session session = getSession();

		Query query = session.createQuery("from Suppliers");
		List<Suppliers> supplierList = query.list();

		return supplierList;
	}

	

	public Boolean updateSuppliers(Suppliers suppliers) {
		try{
		Session session = getSession();

		String s = suppliers.getSupplierName();

		session.update(suppliers);

		session.flush();

		session.close();
		return true;
		}
		catch(HibernateException e)
		{ return false;
		}
		
	}

	public Boolean deleteSuppliers(int supplierId) {
		// TODO Auto-generated method stub
		try{
		Session session = getSession();

		Query query = session.createQuery("from Suppliers where userId = ?");
		query.setInteger(0, supplierId);

		Suppliers u=(Suppliers) query.uniqueResult();
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
