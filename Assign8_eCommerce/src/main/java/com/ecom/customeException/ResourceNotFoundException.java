package com.ecom.customeException;

public class ResourceNotFoundException extends RuntimeException {
	

	public ResourceNotFoundException(String errMesg) {
		super(errMesg);
		
	}
	
	

}
