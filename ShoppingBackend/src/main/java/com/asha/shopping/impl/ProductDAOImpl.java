package com.asha.shopping.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.asha.shopping.DAO.ProductDAO;
import com.asha.shopping.model.Product;

public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public boolean save(Product product) {
		try
		{
		product.setAdded_date(new Date(System.currentTimeMillis()));
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(int productId) {
	
			try {
				//if the product exist, then only delete
				Product product = get(productId);
				if(product==null)
				{
					return false;
				}
				sessionFactory.getCurrentSession().delete(product);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
	
	}

	public Product get(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Product update(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> list(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

}
