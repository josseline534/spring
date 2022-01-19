package com.curso.demo01.services;

import java.util.List;

import com.curso.demo01.entidad.Product;

public interface IProduct {
	List<Product> getProducts();
	Product getProduct(Long id);
	void createProduct (Long id, String name, Integer price);
	
}
