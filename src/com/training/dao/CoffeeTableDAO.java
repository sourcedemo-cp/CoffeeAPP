package com.training.dao;

import java.util.List;

import com.training.entity.CoffeeTable;

public interface CoffeeTableDAO {
	
	public List<CoffeeTable> getAllCoffeeTable();
	public List<CoffeeTable> getCoffeeTableByID(int id);
	public CoffeeTable findCoffeeTableById(Integer id);
	public int addCoffeeTable(CoffeeTable coffeeTable);
	public boolean deleteCoffeeTableById(int id);
	public int updateCoffeeTable(CoffeeTable coffeeTable);
	
}
