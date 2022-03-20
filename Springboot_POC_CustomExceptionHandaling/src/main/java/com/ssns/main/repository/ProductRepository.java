package com.ssns.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssns.main.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByPid(int id);

	Product findByPname(String name);

}
