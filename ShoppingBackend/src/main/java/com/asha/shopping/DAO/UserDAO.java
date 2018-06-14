package com.asha.shopping.DAO;

import java.util.List;

import com.asha.shopping.model.User;

public interface UserDAO {

	public boolean save(User user);
	public boolean delete(String emailID);

	public boolean update(User user);
	public User validate(String emailId, String password);
	public List<User> list();
	public User get(String emailId);

	//public List<User> get(char role);
	
}
