package com.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.training.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> employees = sessionFactory.getCurrentSession()
				.createQuery("SELECT employee FROM Employee employee").list();
		return employees;
	}

	@Override
	@Transactional
	public int addEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
		return 1;
	}

	@Override
	@Transactional
	public boolean deleteEmployeeById(Employee employee) {
		if (null != employee) {
			sessionFactory.getCurrentSession().delete(employee);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public int updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Employee findEmployeeById(int id) {
		List<Employee> employees = sessionFactory
				.getCurrentSession()
				.createQuery("SELECT e FROM Employee e WHERE e.employeeId=:id")
				.setParameter("id", id).list();
		return employees.size() > 0 ? employees.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public boolean isEmployeeByUsernamePassword(String userName, String password) {
		List<Employee> employees = sessionFactory.getCurrentSession().createQuery("SELECT e FROM Employee e WHERE e.userName = :userName AND e.password = :password").setParameter("userName", userName).setParameter("password", password).list();
		if(null == employees){
			return false;
		}else {
			return employees.size() > 0 ? true : false;
		}
	}

}
