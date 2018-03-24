package org.nextgen.ecomm.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EcommExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({InventoryNotAvailableException.class})
	private ResponseEntity<Object> handleInventoryNotAvailableException(InventoryNotAvailableException inventoryNotAvailableException) throws IOException {

		ApiError apiError= new ApiError(HttpStatus.NOT_FOUND);
		apiError.setMessage(inventoryNotAvailableException.getMessage());
		 return buildResponseEntity(apiError);
	}

	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}

}
