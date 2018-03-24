package org.nextgen.ecomm.exception;

public class InventoryNotAvailableException extends RuntimeException{

	private static final long serialVersionUID = 202810372816267674L;

	public InventoryNotAvailableException(String message) {
		
		super(message);

	}

	@Override
	public String getMessage() {

		return super.getMessage();
	}
}
