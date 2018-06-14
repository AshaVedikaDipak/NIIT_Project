package com.asha.shopping;

import static org.junit.Assert.*;

import org.hibernate.SessionFactory;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.asha.shopping.DAO.CategoryDAO;
import com.asha.shopping.DAO.ProductDAO;
import com.asha.shopping.config.ApplicationContextConfiguration;
import com.asha.shopping.model.Product;

import junit.framework.Assert;

public class ProductTestCase {

	private static  AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;
	
	@BeforeClass
	public static void initialize()
	{
		context=new  AnnotationConfigApplicationContext();
		context.scan("com.asha");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		product=(Product)context.getBean("product");
	
	}
	@Test
	public void saveProductTest() {
		
	Product product=new Product();
	product.setProductId(5);
	product.setProductName("Educational Toys");
	product.setPrice(669);
	product.setStock(6);
	product.setProdDesc("Foocat English Learner laptop for kids with 20 activities  (Green)");
	product.setCategoryId(7);
	product.setCategoryName("Toys");
	boolean actual =productDAO.save(product);
	
	Assert.assertEquals(true, actual);	
	}
    
	@SuppressWarnings("deprecation")
	@Test
	public void deleteProductSuccessTestCase()
	{
		Assert.assertEquals(true, productDAO.delete(2));
	}
}
