package com.spring.cloud.employeesystem.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@ControllerAdvice
@RestController
@Api(value = "Exception Handler")
public class ExceptionHandlerClass extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	@ApiOperation(value = "Will handle Internal Server Errors")
	public final ResponseEntity<Object> handleAllExceptions(WebRequest req, Exception ex){
		return new ResponseEntity<Object>(new ErrorResponse("Internal Server Error",
				ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public final ResponseEntity<Object> employeeNotFound(WebRequest req, Exception ex){
		return new ResponseEntity<Object>(new ErrorResponse
				("Error, Not Found", ex.getMessage(), HttpStatus.NOT_FOUND.value(), new Date()), 
				HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		return new ResponseEntity<Object>(new ErrorResponse("Validation Has Failed", 
				ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value(), new Date()),
				HttpStatus.BAD_REQUEST);
	}
}
