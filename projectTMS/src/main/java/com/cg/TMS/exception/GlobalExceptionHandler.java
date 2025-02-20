package com.cg.TMS.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(UserNotFoundException exception, WebRequest request) {
		//System.out.println("ERROR --> " +exception.getMessage());

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException1(TaskNotFoundException exception, WebRequest request) {
		//System.out.println("ERROR --> " +exception.getMessage());

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(LeaveNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException2(LeaveNotFoundException exception, WebRequest request) {
		//System.out.println("ERROR --> " +exception.getMessage());

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProjectIdNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException3(ProjectIdNotFoundException exception, WebRequest request) {
		//System.out.println("ERROR --> " +exception.getMessage());

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RequestNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException4(RequestNotFoundException exception, WebRequest request) {
		//System.out.println("ERROR --> " +exception.getMessage());

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
	}

}
