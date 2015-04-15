package com.training.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.training.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Product> getAllProduct() {
		List<Product> products = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Product p").list();
		return products;
	}

	@Override
	@Transactional
	public int addProduct(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return 1;
	}

	@Override
	@Transactional
	public boolean deleteProductById(Product product) {
		if (null != product) {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public int updateProduct(Product product) {
		sessionFactory.getCurrentSession().update(product);	
		return 1;
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Product findProductById(Integer id) {
		List<Product> products = sessionFactory.getCurrentSession().createQuery("SELECT p FROM Product p WHERE p.productId = :id").setParameter("id", id).list();
		return products.size() > 0? products.get(0) : null;
	}

}
