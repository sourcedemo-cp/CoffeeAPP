package com.training.dao;

import java.util.List;

import com.training.entity.Order;

public interface OrderDAO {
	public List<Order> getAllOrder();
	public int addOrder(Order order);
	public boolean deleteOrderByID(Order order);
	public int updateOrder(Order order);
	public Order findOrderByID(int id);
}
// test n�t pull trong syn