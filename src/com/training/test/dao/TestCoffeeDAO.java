package com.training.test.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.training.dao.CoffeeTableDAO;
import com.training.entity.CoffeeTable;

public class TestCoffeeDAO {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		CoffeeTableDAO coffeeTableDAO = (CoffeeTableDAO) context.getBean("coffeeTableDAOImpl");
		List<CoffeeTable> coffeeTables = coffeeTableDAO.getCoffeeTalbeByID(1);
		if(null != coffeeTables){
//			for (CoffeeTable coffeeTable : coffeeTables) {
//				System.out.println(coffeeTable.getOrders().get(0).getEmployee()a);
//			}
		}
		
//		CoffeeTable coffeeTable = coffeeTableDAO.findCoffeeTableById(1);
//		if(coffeeTable != null){
//			System.out.println("OK");
//		}else{
//			System.out.println("null");
//		}
	}
}
