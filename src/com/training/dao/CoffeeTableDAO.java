package com.training.dao;

import java.util.List;

import com.training.entity.CoffeeTable;
import com.training.entity.OrderDetail;

public interface CoffeeTableDAO {
	public List<CoffeeTable> getAllCoffeeTable();
	public List<CoffeeTable> getCoffeeTalbeByID(int id);
	public CoffeeTable findCoffeeTableById(Integer id);
	public int addCoffeeTable(CoffeeTable coffeeTable);
	public boolean deleteCoffeeTableById(CoffeeTable coffeeTable);
	public int updateCoffeeTable(CoffeeTable coffeeTable);
}
