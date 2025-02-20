package com.cg.TMS.exception;

public class LeaveNotFoundException extends RuntimeException {

	private String message;

	//CONSTRUCTOR
	public LeaveNotFoundException(String message) {
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
