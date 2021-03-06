package com.training.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.OrderDetailDAO;
import com.training.entity.OrderDetail;

public class TestOderDetailDAO {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		OrderDetailDAO orderDetailDAO = (OrderDetailDAO) context.getBean("orderDetailDAOImpl");
		List<OrderDetail> orderDetails = orderDetailDAO.findOrderDetailByOrderId(1);
		if(null != orderDetails) {
			System.out.println(orderDetails.size());
			for (OrderDetail orderDetail : orderDetails) {
				System.out.println(orderDetail.getOrderDetailId());
				System.out.println(orderDetail.getProduct().getProductName());
				System.out.println(orderDetail.getProduct().getProductPrice());
				System.out.println(orderDetail.getQuantity());
			}
		} else {
			System.out.println("Empty list");
		}
		System.out.println(orderDetailDAO.sumOfOrderDetailByOrderId(1));
	}

}
