package com.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.entity.CoffeeTable;
import com.training.entity.OrderDetail;

@Repository
public class OrderDetailDAOImpl implements OrderDetailDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<OrderDetail> getAllOrderDetail() {
		List<OrderDetail> orderDetails = sessionFactory.getCurrentSession().createQuery("SELECT od FROM OrderDetail od JOIN FETCH od.product pr JOIN FETCH od.order os").list();
	return orderDetails;
	}

	@Override
	@Transactional
	public int addOrderDetail(OrderDetail orderdetail) {
		sessionFactory.getCurrentSession().save(orderdetail);
		return 1;
	}

	@Override
	@Transactional
	public boolean deleteOrderDetailById(OrderDetail orderdetail) {
		if(orderdetail != null){
			sessionFactory.getCurrentSession().delete(orderdetail);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public int updateOrderDetail(OrderDetail orderdetail) {
		sessionFactory.getCurrentSession().update(orderdetail);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public OrderDetail findOrderDetailById(int id) {
		List<OrderDetail> orderDetails = sessionFactory.getCurrentSession().createQuery("SELECT od FROM OrderDetail od JOIN FETCH od.product pr JOIN FETCH od.order os WHERE os.coffeeTable = :id").setParameter("id", id).list();
		return orderDetails.size()>0?orderDetails.get(0):null;
	}

	@Override
	@Transactional
	public List<OrderDetail> getOrderDetailByID(int id) {
		String sql = "SELECT od FROM OrderDetail od JOIN FETCH od.product pr JOIN FETCH od.order o JOIN FETCH o.coffeeTable tb WHERE tb.tableId = :id";
		List<OrderDetail> orderDetails = sessionFactory.getCurrentSession().createQuery(sql).setParameter("id", id).list();
		return orderDetails;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<OrderDetail> findOrderDetailByOrderId(int id) {
		String sql = "SELECT ord FROM OrderDetail ord JOIN FETCH ord.product p JOIN FETCH ord.order o WHERE o.orderId = :id";
		List<OrderDetail> orderDetails = sessionFactory.getCurrentSession().createQuery(sql).setParameter("id", id).list();
		return orderDetails;
	}
}
