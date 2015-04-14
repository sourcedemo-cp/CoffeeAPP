package com.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.entity.Order;
import com.training.entity.OrderDetail;

@Repository
public class OrderDAOImpl implements OrderDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Order> getAllOrder() {
		List<Order> orders = sessionFactory.getCurrentSession().createQuery("SELECT o FROM Order o").list();
		return orders;
	}
	@Override
	@Transactional
	public int addOrder(Order order) {
		sessionFactory.getCurrentSession().save(order);
		return 1;
	}
	@Override
	@Transactional
	public boolean deleteOrderByID(Order order) {
		// TODO Auto-generated method stub
		//Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, id);
		if(order != null){
			sessionFactory.getCurrentSession().delete(order);
			return true;
		}
		return false;
	}
	@Override
	@Transactional
	public int updateOrder(Order order) {
		sessionFactory.getCurrentSession().update(order);
		return 1;
	}
	
	@Override
	@Transactional
	public Order findOrderByID(int id) {
		List<Order> orders = sessionFactory.getCurrentSession().createQuery("SELECT o FROM Order o WHERE o.orderId = :id").setParameter("id", id).list();
		return orders.size()>0?orders.get(0):null;
	}
	@Override
	@Transactional
	public List<Order> findOrderByCoffeeTableId(int id) {

		String sql = "SELECT o FROM Order o JOIN o.coffeeTable t WHERE t.tableId = :id ORDER BY o.datePayment DESC";
		List<Order> orders = sessionFactory.getCurrentSession().createQuery(sql).setParameter("id", id).list();
		return orders;
	}
	@Override
	@Transactional
	public List<Order> getOrderByTableID(int id) {
		String sql = "SELECT od FROM Order od JOIN FETCH od.coffeeTable tb WHERE tb.tableId = :id";
		List<Order> orderDetails = sessionFactory.getCurrentSession().createQuery(sql).setParameter("id", id).list();
		return orderDetails;
	}
	@Override
	@Transactional
	public boolean deleteOrderById(int id) {
		Order order = (Order) sessionFactory.getCurrentSession().load(Order.class, id);
		if(null != order){
			sessionFactory.getCurrentSession().delete(order);
			return true;
		}
		return false;
	}

	

}
