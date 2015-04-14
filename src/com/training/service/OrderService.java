package com.training.service;

import java.util.List;

import com.training.entity.Order;

public interface OrderService {
	public List<Order> getAllOrder();
	public int addOrder(Order order);
	public boolean deleteOrderByID(Order order);
	public int updateOrder(Order order);
	public Order findOrderByID(int id);
	public List<Order> findOrderByCoffeeTableId(int id);
}
