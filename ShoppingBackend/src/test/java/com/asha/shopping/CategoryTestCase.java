package com.asha.shopping;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.asha.shopping.DAO.CategoryDAO;
import com.asha.shopping.model.Category;

import junit.framework.Assert;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;
	private static Category category;
	
	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.asha");
		context.refresh();
		categoryDAO = (CategoryDAO)context.getBean("categoryDAO");
		category=(Category)context.getBean("category");
	}
	@Ignore
	@Test
	public void saveCategoryTest() 
	{
		
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("Laptop/Desctops");
		category.setCategoryDesc("all Laptop/Desctops");
		boolean actual =categoryDAO.save(category);
		
		Assert.assertEquals(true, actual);	
	}
	
	
	@SuppressWarnings("deprecation")
	@Test
	public void deleteCategorySuccessTestCase()
	{				
		//Category category=categoryDAO.get(5);
		assertTrue("Problem in Deleting:",categoryDAO.delete(33));
		
	}
	
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.get(33);
		category.setCategoryId(1);
		
		assertTrue("Problem in Updating",categoryDAO.update(category));
	}
	@Ignore
	@Test
	public void getAllCategoriesTestCase()
	{
		//compare how many records are there in db and how many
		//are coming from dao.
	 Assert.assertEquals(6,	categoryDAO.list().size());
	}
}
