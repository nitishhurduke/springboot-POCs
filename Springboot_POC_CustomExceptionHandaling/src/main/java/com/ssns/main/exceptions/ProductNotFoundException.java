package com.ssns.main.exceptions;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
