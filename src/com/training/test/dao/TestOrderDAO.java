package com.training.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.OrderDAO;
import com.training.entity.Order;

public class TestOrderDAO {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		OrderDAO orderDAO = (OrderDAO) context.getBean("orderDAOImpl");
		List<Order> orders = orderDAO.getOrderByTableID(1);
		if(null != orders){
			System.out.println("OK");
		}
	}

}
