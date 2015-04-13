package com.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.dao.CoffeeTableDAO;
import com.training.entity.CoffeeTable;

@Service
public class CoffeeTableServiceImpl implements CoffeeTableService{
	@Autowired
	private CoffeeTableDAO cfDAO;
	
	@Override
	public List<CoffeeTable> getAllCoffeeTable() {
		// TODO Auto-generated method stub
		return cfDAO.getAllCoffeeTable();
	}

	@Override
	public CoffeeTable findCoffeeTableById(Integer id) {
		// TODO Auto-generated method stub
		return cfDAO.findCoffeeTableById(id);
	}

	@Override
	public int addCoffeeTable(CoffeeTable coffeeTable) {
		// TODO Auto-generated method stub
		cfDAO.addCoffeeTable(coffeeTable);
		return 1;
	}

	@Override
	public boolean deleteCoffeeTableById(CoffeeTable coffeeTable) {
		// TODO Auto-generated method stub
		return cfDAO.deleteCoffeeTableById(coffeeTable);
	}

	@Override
	public int updateCoffeeTable(CoffeeTable coffeeTable) {
		// TODO Auto-generated method stub
		cfDAO.updateCoffeeTable(coffeeTable);
		return 1;
		
	}

	@Override
	public List<CoffeeTable> getCoffeeTalbeByID(int id) {
		cfDAO.getCoffeeTalbeByID(id);
		return null;
	}

}
