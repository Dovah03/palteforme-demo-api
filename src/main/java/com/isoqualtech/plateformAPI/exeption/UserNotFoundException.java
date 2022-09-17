package com.isoqualtech.plateformAPI.exeption;

public class UserNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4599510465841195221L;

	public UserNotFoundException(String message) {
		super(message);
	}
	
}
