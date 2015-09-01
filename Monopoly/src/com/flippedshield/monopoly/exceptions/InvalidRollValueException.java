package com.flippedshield.monopoly.exceptions;

public class InvalidRollValueException extends Exception {

	private static final long serialVersionUID = -7038769375145154585L;

	public InvalidRollValueException()
	{
		
	}
	
	public InvalidRollValueException(String message)
	{
		super(message);
	}
	
	public InvalidRollValueException(Throwable cause)
	{
		super(cause);
	}
	
	public InvalidRollValueException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
