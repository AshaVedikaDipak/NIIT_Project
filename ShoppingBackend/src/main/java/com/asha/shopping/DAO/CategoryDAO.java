package com.asha.shopping.DAO;

import java.util.List;

import com.asha.shopping.model.Category;

public interface CategoryDAO
{

		public boolean save(Category category);
		public boolean delete(int categoryId);
		public boolean update(Category category);
		public List<Category> list();
		public Category get(int categoryId);

		//public List<Category> get(char role);
}
