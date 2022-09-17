package com.isoqualtech.plateformAPI.exeption;

public class DevisNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8114614151510057748L;
	public DevisNotFoundException(String message) {
		super(message);
	}
}
