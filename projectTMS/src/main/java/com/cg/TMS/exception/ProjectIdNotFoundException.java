package com.cg.TMS.exception;
public class ProjectIdNotFoundException extends RuntimeException {
	
	private String message;

	

	public ProjectIdNotFoundException(String message) {
		super();
		// TODO Auto-generated constructor stub
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}