package com.training.dao;

import java.util.List;

import com.training.entity.Order;
import com.training.entity.OrderDetail;

public interface OrderDAO {
	public List<Order> getAllOrder();
	public List<Order> getOrderByTableID(int id);
	public int addOrder(Order order);
	public boolean deleteOrderByID(Order order);
	public int updateOrder(Order order);
	public Order findOrderByID(int id);
	public List<Order> findOrderByCoffeeTableId(int id);
	public boolean deleteOrderById(int id);
}