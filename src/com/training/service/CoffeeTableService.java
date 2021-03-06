package com.training.service;

import java.util.List;

import com.training.entity.CoffeeTable;

public interface CoffeeTableService {
	
	public List<CoffeeTable> getAllCoffeeTable();
	public List<CoffeeTable> getCoffeeTableByID(int id);
	public CoffeeTable findCoffeeTableById(Integer id);
	public int addCoffeeTable(CoffeeTable coffeeTable);
	public boolean deleteCoffeeTableById(int id);
	public int updateCoffeeTable(CoffeeTable coffeeTable);
	
}
