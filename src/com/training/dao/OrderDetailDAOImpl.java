package com.training.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
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

	@Override
	@Transactional
	public long sumOfOrderDetailByOrderId(int id) {
		long result = 0;
		String sql = "SELECT SUM(ord.quantity * p.productPrice) FROM OrderDetail ord JOIN ord.order o JOIN ord.product p  WHERE o.orderId = :id";
		Query query = sessionFactory.getCurrentSession().createQuery(sql).setParameter("id", id);
		for(Iterator it=query.iterate();it.hasNext();){
			result = (long) it.next();
		}
		return  result;
	}

	@Override
	@Transactional
	public boolean deleteOrderDetailByID(int id) {
		OrderDetail orderDetail = (OrderDetail) sessionFactory.getCurrentSession().load(OrderDetail.class, id);
		if (null != orderDetail) {
			sessionFactory.getCurrentSession().delete(orderDetail);
			return true;
		}
		return false;
	}
}
