package com.asha.shopping.impl;
 
import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.asha.shopping.DAO.CategoryDAO;
import com.asha.shopping.model.Category;
import com.asha.shopping.model.User;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO
{

		@Autowired
		private SessionFactory sessionFactory;
		@Transactional
		public boolean save(Category category) {
			try {
				//set the current system date to category
				category.setAdded_date(new Date(System.currentTimeMillis()));
				//save method will create new record
				//modify saveOrUpdate
				//saveOrUpdate - will save if it is new record
				//will update if is existing record.
				sessionFactory.getCurrentSession().saveOrUpdate(category);
				return true;
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
	}

	@Transactional
	public boolean delete(int categoryId) {

		try
		{Category category = get(categoryId);
		if(category==null)
		{
			return false;
		}
			sessionFactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
		}
	@Transactional	
	public boolean update(Category category) {
	try
	{
		sessionFactory.getCurrentSession().update(category);
		return true;
	
	}catch(Exception e)
	{
		e.getStackTrace();
		return false;
	}
		
	}

	
@Transactional
	public List<Category> list() 
	{
		return	sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category get(int categoryId) {
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryId);
		session.close();
		return category;
	}
}
