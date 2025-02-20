package com.cg.TMS.exception;

public class TaskNotFoundException extends RuntimeException {

	private String message;

	//CONSTRUCTOR
	public TaskNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
