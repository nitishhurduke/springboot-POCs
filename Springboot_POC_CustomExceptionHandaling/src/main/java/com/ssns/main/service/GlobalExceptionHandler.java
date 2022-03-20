package com.ssns.main.service;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssns.main.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public String productNotFound(ProductNotFoundException e) {
		return e.getMessage();
	}
}
