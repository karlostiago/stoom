package com.ctsousa.stoom.exception;

public class AddressNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = 1072568377142455006L;
	
	public AddressNotFoundException(String message) {
		super(message);
	}
	
	public AddressNotFoundException(Long id) {
		this(String.format("There is no address record with code %d", id));
	}
}
