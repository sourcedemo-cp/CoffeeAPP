package com.training.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.ProductDAO;
import com.training.entity.Product;

public class TestProductDAO {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAOImpl");
		List<Product> products = productDAO.getAllProduct();
		if(null != products){
			System.out.println("OK");
			System.out.println(products.size());
		}else {
			System.out.println("Null");
		}
	}
}
