package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.CoffeeTableDAO;
import com.training.entity.CoffeeTable;

@Service
public class CoffeeTableServiceImpl implements CoffeeTableService{
	
	@Autowired
	private CoffeeTableDAO coffeeTableDAO;
	
	@Override
	public List<CoffeeTable> getAllCoffeeTable() {
		return coffeeTableDAO.getAllCoffeeTable();
	}

	@Override
	public CoffeeTable findCoffeeTableById(Integer id) {
		return coffeeTableDAO.findCoffeeTableById(id);
	}

	@Override
	public int addCoffeeTable(CoffeeTable coffeeTable) {
		coffeeTableDAO.addCoffeeTable(coffeeTable);
		return 1;
	}

	@Override
	public boolean deleteCoffeeTableById(int id) {
		return coffeeTableDAO.deleteCoffeeTableById(id);
	}

	@Override
	public int updateCoffeeTable(CoffeeTable coffeeTable) {
		coffeeTableDAO.updateCoffeeTable(coffeeTable);
		return 1;
		
	}

	@Override
	public List<CoffeeTable> getCoffeeTalbeByID(int id) {
		coffeeTableDAO.getCoffeeTalbeByID(id);
		return null;
	}

}
