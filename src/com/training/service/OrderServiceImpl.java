package com.training.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.OrderDAO;
import com.training.entity.Order;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<Order> getAllOrder() {
		return orderDAO.getAllOrder();
	}

	@Override
	public boolean addOrder(Order order) {
		return orderDAO.addOrder(order);
	}

	@Override
	public boolean deleteOrderByID(Order order) {
		return orderDAO.deleteOrderByID(order);
	}

	@Override
	public int updateOrder(Order order) {
		orderDAO.updateOrder(order);
		return 1;
	}

	@Override
	public Order findOrderByID(int id) {
		return orderDAO.findOrderByID(id);
	}

	@Override
	public List<Order> findOrderByCoffeeTableId(int id) {
		return orderDAO.findOrderByCoffeeTableId(id);
	}

	@Override
	public List<Order> getOrderByTableID(int id) {
		return orderDAO.getOrderByTableID(id);
	}

	@Override
	public boolean deleteOrderById(int id) {
		return orderDAO.deleteOrderById(id);
	}
	
}
