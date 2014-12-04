package com.alm.exceptions;

public class ALMException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2888905663117701727L;
	String message;

	public ALMException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ALMException [message=" + message + "]";
	}
	

}
