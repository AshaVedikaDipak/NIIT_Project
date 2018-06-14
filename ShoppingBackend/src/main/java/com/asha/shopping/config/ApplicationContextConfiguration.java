package com.asha.shopping.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.asha.shopping.DAO.*;
import com.asha.shopping.impl.*;
import com.asha.shopping.model.*;

@Configuration
@ComponentScan("com.asha")
@EnableTransactionManagement
public class ApplicationContextConfiguration {

	@Bean(name = "dataSource")
	public DataSource getDataH2Source() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");

		dataSource.setDriverClassName("org.h2.Driver");

		dataSource.setUsername("sa");
		//dataSource.setPassword("");
		System.out.println("---------datasource created--------");
		
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		
		Properties hibernateProp=new Properties();
		
		hibernateProp.setProperty("hibernate.hbm2ddl.auto", "update");
		//hibernateProp.setProperty("hibernate.show.sql", "true");
		hibernateProp.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getDataH2Source());
		factoryBuilder.addAnnotatedClass(Category.class);
		factoryBuilder.addAnnotatedClass(Product.class);
		factoryBuilder.addAnnotatedClass(User.class);
		//factoryBuilder.addAnnotatedClass(CartItem.class);
		//factoryBuilder.addAnnotatedClass(OrderDetail.class);
		
		factoryBuilder.addProperties(hibernateProp);
		
		System.out.println("Creating SessionFactory Bean");
		return factoryBuilder.buildSessionFactory();
	}
	

	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println("----user DAO Implementation---");
		return new UserDAOImpl();
	}
	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("----category DAO Implementation---");
		return new CategoryDAOImpl();
	}
	
	@Autowired
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("----Product DAO Implementation---");
		return new ProductDAOImpl();
	}
	
	
	//Automatically inject the instance
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("transaction manager");
		return transactionManager;
		
		
	}

	
}
