package com.ctsousa.stoom.exception;

public class EntityNotFoundException extends BusinessException {

	private static final long serialVersionUID = 1382930527879580908L;
	
	public EntityNotFoundException(String message) {
		super(message);
	}
}
