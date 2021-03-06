package com.training.dao;

import java.util.List;

import com.training.entity.Product;

public interface ProductDAO {
	
	public List<Product> getAllProduct();
	public int addProduct(Product product);
	public boolean deleteProductById(Product product);
	public int updateProduct(Product product);
	public Product findProductById(Integer id);
	
}
