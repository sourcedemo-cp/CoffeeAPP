package com.training.service;

import java.util.List;

import com.training.entity.CoffeeTable;

public interface CoffeeTableService {
	public List<CoffeeTable> getAllCoffeeTable();
	public List<CoffeeTable> getCoffeeTalbeByID(int id);
	public CoffeeTable findCoffeeTableById(Integer id);
	public int addCoffeeTable(CoffeeTable coffeeTable);
	public boolean deleteCoffeeTableById(CoffeeTable coffeeTable);
	public int updateCoffeeTable(CoffeeTable coffeeTable);
}
