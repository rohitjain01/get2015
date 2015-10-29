package com.Exceptions;

public class VehicleDekhoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VehicleDekhoException(String message) {
		super(message);
	}
	
	public VehicleDekhoException(String message, Throwable cause) {
		super(message, cause);
	}
}
