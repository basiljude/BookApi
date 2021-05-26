package com.example.demo.Exception;

public class IsbnConstraintViolationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IsbnConstraintViolationException(String message) {
		super(message);
	}
}
