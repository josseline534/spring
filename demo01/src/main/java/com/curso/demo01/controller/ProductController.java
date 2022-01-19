package com.curso.demo01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.demo01.entidad.Product;
import com.curso.demo01.services.IProduct;

@RestController
@RequestMapping(value = "products")
public class ProductController {
	
	@Autowired
	private IProduct productService;
	
	@GetMapping(path = "")
	List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping(path ="/{id}")
	public Product getProduct(@PathVariable("id") Long id) {
		return productService.getProduct(id);
	}
	
	@PostMapping(path = "")
	public Map<String, Object> createProduct (
			@RequestParam(value = "id") Long id,
			@RequestParam(value = "name")String name,
			@RequestParam(value = "price")Integer price) {
		
		productService.createProduct(id, name, price);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status","Product added !");
		return map;
	}
}
