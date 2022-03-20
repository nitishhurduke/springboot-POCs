package com.ssns.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssns.main.exceptions.ProductNotFoundException;
import com.ssns.main.model.Product;
import com.ssns.main.repository.ProductRepository;

@Service
public class productServiceimpl implements ProductService{

	@Autowired
	ProductRepository repo;
	
	
	@Override
	public Product saveProduct(Product product) {
		return repo.save(product);
	}


	@Override
	public List<Product> findAllproducts() {
		return repo.findAll();
	}

	@Override
	public Product findProductbyId(int id) {
		
		Product product = repo.findByPid(id);
  
		if(product != null) {
			return product ;
		}else {
			throw new ProductNotFoundException("Product with given ID : '"+id+"' is not found");
		}
	}


	@Override
	public Product findProductByName(String name) {
		
		Product product = repo.findByPname(name);
		  
		if(product != null) {
			return product ;
		}else {
			throw new ProductNotFoundException("Product with given Name:  '"+name+"' is not found");
		}
	}
}
