package com.ssns.main.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity< String> productNotFound(ProductNotFoundException e) {
		return new ResponseEntity<String>( e.getMessage(),HttpStatus.NOT_FOUND);
	}
}
