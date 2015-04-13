package com.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.entity.CoffeeTable;
import com.training.entity.OrderDetail;

@Repository
public class CoffeeTableDAOImpl implements CoffeeTableDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CoffeeTable> getAllCoffeeTable() {
		List<CoffeeTable> coffeeTables = sessionFactory.getCurrentSession()
				.createQuery("SELECT ct FROM CoffeeTable ct").list();
		return coffeeTables;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public CoffeeTable findCoffeeTableById(Integer id) {
		List<CoffeeTable> coffeeTables = sessionFactory
				.getCurrentSession()
				.createQuery(
						"SELECT ct FROM CoffeeTable ct WHERE ct.tableId = :id")
				.setParameter("id", id).list();
		return coffeeTables.size() > 0 ? coffeeTables.get(0) : null;
	}

	@Override
	@Transactional
	public int addCoffeeTable(CoffeeTable coffeeTable) {
		sessionFactory.getCurrentSession().save(coffeeTable);
		return 1;
	}

	@Override
	@Transactional
	public boolean deleteCoffeeTableById(CoffeeTable coffeeTable) {
		//CoffeeTable coffeeTable = (CoffeeTable) sessionFactory.getCurrentSession().load(CoffeeTable.class, id);
		if(null != coffeeTable){
			sessionFactory.getCurrentSession().delete(coffeeTable);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public  int updateCoffeeTable(CoffeeTable coffeeTable) {
		sessionFactory.getCurrentSession().update(coffeeTable);
		return 1;
	}

	@Override
	@Transactional
	public List<CoffeeTable> getCoffeeTalbeByID(int id) {
		String sql = "SELECT tb FROM CoffeeTable tb JOIN FETCH tb.orders o JOIN o.orderDetails od JOIN od.product pr WHERE tb.tableId = :id";
		//String sql = "SELECT tb FROM CoffeeTable tb JOIN FETCH tb.orders o";
		List<CoffeeTable> coffeeTables = sessionFactory.getCurrentSession().createQuery(sql).setParameter("id", id).list();
		return coffeeTables;
	}
	

}
