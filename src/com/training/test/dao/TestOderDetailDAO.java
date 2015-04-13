package com.training.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.OrderDetailDAO;
import com.training.entity.OrderDetail;

public class TestOderDetailDAO {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		OrderDetailDAO orderDetailDAO = (OrderDetailDAO) context.getBean("orderDetailDAOImpl");
		List<OrderDetail> orderDetails = orderDetailDAO.getOrderDetailByID(1);
		if(null != orderDetails){
			
			System.out.println(orderDetails.size());
			for (OrderDetail orderDetail : orderDetails) {
				System.out.println(orderDetail.getOrderDetailId());
				System.out.println(orderDetail.getProduct().getProductName());
				
				System.out.println(orderDetail.getProduct().getProductPrice());
				System.out.println(orderDetail.getQuantity());
				System.out.println(orderDetail.getPayment());
			}
			
			// chet. em co get cai gi lien quan den table ko?, hinh nhu ko
			// neu em co lay gi lien quan den table thi em phai viet method nay ben TableDAOImpl
			// em chi hien thi tat ca tai vi tri table id thoy, chu ko get tableid
			// anh nghi method nay nen de ben TableCoffeeDAO, ok
			
		}else{
			System.out.println("Empty list");
		}
	}

}
