package com.ssns.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssns.main.model.Product;
import com.ssns.main.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@PostMapping(value = "/product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
		
		return new ResponseEntity<Product>(service.saveProduct(product),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/product")
	public ResponseEntity< List<Product>> findAllProducts (){
		return new ResponseEntity< List<Product>>(service.findAllproducts(),HttpStatus.OK);
	}
	
	@GetMapping("/product/{name}")
	public ResponseEntity<Product> findProductByName(@PathVariable("name") String name)
	{
		Product product = service.findProductByName(name);
		
		return new ResponseEntity<Product> (product,HttpStatus.OK);
	
	}
	
	@PutMapping(value = "/product/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable int id ){
		
		return new ResponseEntity<Product>(service.updateProduct(product,id),HttpStatus.CREATED);
	}
	@DeleteMapping(value = "product/{id}")
	public ResponseEntity<String>deleteProduct(@PathVariable int id){
		service.deleteProduct(id);
		return new ResponseEntity<String>("Product deleted Successfully....!!",HttpStatus.NO_CONTENT);
	}
}
