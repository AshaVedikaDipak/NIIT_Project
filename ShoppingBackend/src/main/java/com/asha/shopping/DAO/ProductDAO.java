package com.asha.shopping.DAO;

import java.util.List;

import com.asha.shopping.model.Product;

public interface ProductDAO 
{
	public boolean save(Product product);
	public boolean delete(int productId);
	public Product get(int productId);
	public Product update(Product product);
	public List<Product> list(Product product);
}
