package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.ProductDAO;
import com.training.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Override
	public List<Product> getAllProduct() {
		return productDAO.getAllProduct();
	}

	@Override
	public int addProduct(Product product) {
		productDAO.addProduct(product);
		return 1;
	}

	@Override
	public boolean deleteProductById(Product product) {
		return productDAO.deleteProductById(product);
	}

	@Override
	public int updateProduct(Product product) {
		productDAO.updateProduct(product);
		return 1;
	}

	@Override
	public Product findProductById(Integer id) {
		return productDAO.findProductById(id);
	}

}
