package com.training.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.OrderDetailDAO;
import com.training.entity.OrderDetail;

public class TestOrderDetailDAO1 {
	public static void main(String[] args){
//		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//		ProductDAO productDAO = (ProductDAO) context.getBean("productDAOImpl");
//		List<Product> products = productDAO.getAllProduct();
//		if(null != products){
//			System.out.println("OK");
//			System.out.println(products.size());
//		}else {
//			System.out.println("Null");
//		}
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		OrderDetailDAO orderDetailDAO = (OrderDetailDAO) context.getBean("orderDetailDAOimpl");
		List<OrderDetail> orderDetails = orderDetailDAO.getOrderDetailByID(1);
		if(null != orderDetails){
			System.out.println("OK");
			System.out.println(orderDetails.size());
		}else{
			System.out.println("Null");
		}
		
	}
}
