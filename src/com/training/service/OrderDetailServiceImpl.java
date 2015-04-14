package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.OrderDetailDAO;
import com.training.entity.OrderDetail;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	
	@Autowired
	private OrderDetailDAO orderDetailDAO;
	
	@Override
	public List<OrderDetail> getAllOrderDetail() {
		return orderDetailDAO.getAllOrderDetail();
	}

	@Override
	public int addOrderDetail(OrderDetail orderdetail) {
		orderDetailDAO.addOrderDetail(orderdetail);
		return 1;
	}

	@Override
	public boolean deleteOrderDetailById(OrderDetail orderdetail) {
		return orderDetailDAO.deleteOrderDetailById(orderdetail);
	}

	@Override
	public int updateOrderDetail(OrderDetail orderdetail) {
		orderDetailDAO.updateOrderDetail(orderdetail);
		return 1;
	}

	@Override
	public OrderDetail findOrderDetailById(int id) {
		return orderDetailDAO.findOrderDetailById(id);
	}

	@Override
	public List<OrderDetail> getOrderDetailByID(int id) {
		return orderDetailDAO.getOrderDetailByID(id);
	}

	@Override
	public List<OrderDetail> findOrderDetailByOrderId(int id) {
		return orderDetailDAO.findOrderDetailByOrderId(id);
	}

	@Override
	public long sumOfOrderDetailByOrderId(int id) {
		return orderDetailDAO.sumOfOrderDetailByOrderId(id);
	}

}
