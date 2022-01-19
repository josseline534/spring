package com.curso.demo01.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.curso.demo01.entidad.Product;

@Service
public class ProdcutServiceImpl implements IProduct {
	
	public ProdcutServiceImpl() {
		products.add(new Product(1l,"Iphone", 1925 ));
		products.add(new Product(2l,"Speaker", 599 ));
		products.add(new Product(3l,"Computer", 1258 ));
		products.add(new Product(4l,"Book", 50 ));
	}

	List<Product> products = new ArrayList<Product>();
	
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Product getProduct(Long id) {
		Iterator<Product> iterator = products.iterator();
		while(iterator.hasNext()) {
			Product product = iterator.next();
			if(product.getId().equals(id))
				return product;
		}
		return null;
	}

	@Override
	public void createProduct(Long id, String name, Integer price) {
		products.add(new Product(id, name, price));
		
	}

}
