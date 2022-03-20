package com.ssns.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssns.main.exceptions.ProductNotFoundException;
import com.ssns.main.model.Product;
import com.ssns.main.repository.ProductRepository;

@Service
public class productServiceimpl implements ProductService {

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

		return product;
	}

	@Override
	public Product findProductByName(String name) {
		Product product = repo.findByPname(name);
		if (product != null) {
			return product;
		} else {
			throw new ProductNotFoundException("No Product Found with Name: '" + name + "'");
		}
	}

	@Override
	public Product updateProduct(Product product, int id) {

		Product product1 = repo.findByPid(id);
		if (product1.getPid() == product.getPid()) {
			repo.save(product);
			return repo.findByPid(id);
		} else {
			throw new ProductNotFoundException("No Product Found with Id: '" + id + "'");
		}

	}

	@Override
	public void deleteProduct(int id) {
		Product product = repo.findByPid(id);
		if(product != null) {
			repo.delete(product);
		}else {
			throw new ProductNotFoundException("Product doesn't exist with Id: "+id);
		}
	}
}
