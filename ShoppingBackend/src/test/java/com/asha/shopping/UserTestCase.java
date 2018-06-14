package com.asha.shopping;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.asha.shopping.DAO.UserDAO;
import com.asha.shopping.model.User;

public class UserTestCase {
	
private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private static User user;

	@BeforeClass
	public static void initialize()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.asha");
		context.refresh();
		
		userDAO = (UserDAO)context.getBean("userDAO");
		user = (User) context.getBean("user");			
	}
	
	@Test
	public void saveUserTestCase()
	{
		user = new User();
		

		user.setEmailId("dipak123@gmail.com");
		user.setName("Dipak Pail");
		user.setPassword("Dipak@123");
		user.setRole('C');
		user.setMobile("9574220144");
		user.setAddress(" Pune");
		
		boolean result = userDAO.save(user);
		Assert.assertEquals("save user",true,result );
	}
	
	@Ignore
	@Test
	public void deleteUserTestcase()
	{
		boolean actual = userDAO.delete("dipak@123");
		Assert.assertEquals(" delete user test case",true, actual);
	}
	
	@Test
	public void getAllCategoriesTestCase()
	{
		//compare how many records are there in db and how many
		//are coming from dao.
	 Assert.assertEquals(2,	userDAO.list().size());
	}
	@Ignore
	@Test
	public void updateUserTestCase()
	{
	user=	userDAO.get("vedika@gmail.com");
	user.setAddress("Jalgoan");
	
	
	boolean actual = userDAO.update(user);
	Assert.assertEquals(true, actual);
	}
	
	@Test
	public void validateCredentialsSuccess()
	{
		//if the credentials are correct - will return user object
		//else will return null
		user = userDAO.validate("vedika@gmail.com", "Vedika@123");
		
		//expecting is not null   --will compare with actual -- user
		Assert.assertNotNull("validate test case" , user);
	}
	
	@Test
	public void getUserTestCase()
	{
	user=	userDAO.get("vedika@gmail.com");
	Assert.assertNotNull(user);
	}
	
}
