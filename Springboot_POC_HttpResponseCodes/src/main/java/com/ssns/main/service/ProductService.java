package com.ssns.main.service;

import java.util.List;

import com.ssns.main.model.Product;

public interface ProductService {

	Product saveProduct(Product product);

	List<Product> findAllproducts();

	Product findProductbyId(int id);

	Product findProductByName(String name);

	Product updateProduct(Product product, int id);

	void deleteProduct(int id);

}
