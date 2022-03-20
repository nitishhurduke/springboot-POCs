package com.ssns.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssns.main.model.Product;
import com.ssns.main.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping(value = "/product")
	public Product saveProduct(@RequestBody Product product) {
		
		return this.service.saveProduct(product);
	}
	
	@GetMapping(value = "/product")
	public List<Product> findAllProducts (){
		return service.findAllproducts();
	}
	
//	@GetMapping("/product/{id}")
//	public Product findProductById(@PathVariable("id") int id) {
//		return  service.findProductbyId(id);
//	}
	
	@GetMapping("/product/{name}")
	public Product findProductByName(@PathVariable("name") String name)
	{
		return service.findProductByName(name);
	}
}
