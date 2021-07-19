package com.ctsousa.stoom.exception;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -3207696490300865440L;
	
	public BusinessException(String message) {
		super(message);
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
