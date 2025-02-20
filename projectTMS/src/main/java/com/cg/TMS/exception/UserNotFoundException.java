package com.cg.TMS.exception;

public class UserNotFoundException extends RuntimeException {

	private String message;

	//CONSTRUCTOR
	public UserNotFoundException(String message) {
		super();
		this.message = message;
	}


	//GETTERS & SETTERS
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

