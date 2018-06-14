package com.asha.shopping.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.asha.shopping.DAO.UserDAO;
import com.asha.shopping.model.User;


@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private User user;
	
	public boolean save(User user)
	{
		
		try 
		{
			// set current date
			user.setAdded_date(new Date(System.currentTimeMillis()));
			sessionFactory.getCurrentSession().saveOrUpdate(user);
			

		} catch (Exception e)
		{
			// print the complete exception stack trace
			e.printStackTrace();
			return false;
		}
		// above line : opening session saving user in user table.

		// TODO Auto-generated method stub
		return true;
	}

	public User get(String emailId)
	{
		return (User) sessionFactory.getCurrentSession().get(User.class, emailId);	
	}

	 public boolean delete(String emailId ) 
	 {
		 try {
				user = get(emailId);
				if (user == null) {
					return false;
				}
				sessionFactory.getCurrentSession().delete(user);
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
	 }
	public boolean update(User user) {
		try
		{
			sessionFactory.getCurrentSession().update(user);
		} catch (HibernateException e)
		{
			// if any exceptions, the complete error stack trace
			// will print on the console.
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@SuppressWarnings("deprecation")
	public User validate(String mail, String pwd) {
		
		return (User) sessionFactory.getCurrentSession().createCriteria(User.class)
				.add(Restrictions.eq("emailId", mail)).add(Restrictions.eq("password", pwd)).uniqueResult();
	}

	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	
}
