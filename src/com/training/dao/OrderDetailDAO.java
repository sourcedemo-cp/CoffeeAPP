package com.training.dao;

import java.util.List;

import com.training.entity.CoffeeTable;
import com.training.entity.OrderDetail;

public interface OrderDetailDAO {
	public List<OrderDetail> getAllOrderDetail();
	public List<OrderDetail> getOrderDetailByID(int id);
	public int addOrderDetail(OrderDetail orderdetail);
	public boolean deleteOrderDetailById(OrderDetail orderdetail);
	public int updateOrderDetail(OrderDetail orderdetail);
	public OrderDetail findOrderDetailById(int id);
	public List<OrderDetail> findOrderDetailByOrderId(int id);
	public long sumOfOrderDetailByOrderId(int id);
}
