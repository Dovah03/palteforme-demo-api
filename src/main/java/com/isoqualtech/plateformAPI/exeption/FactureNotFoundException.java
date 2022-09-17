package com.isoqualtech.plateformAPI.exeption;

public class FactureNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8114614151510057748L;
	public FactureNotFoundException(String message) {
		super(message);
	}
}
