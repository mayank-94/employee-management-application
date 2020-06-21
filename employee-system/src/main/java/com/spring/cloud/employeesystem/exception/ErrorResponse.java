package com.spring.cloud.employeesystem.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class ErrorResponse {
	
	private String message;
	private String description;
	private int code;
	
	@JsonFormat(shape = Shape.STRING, pattern = "dd-MM-yyyy")
	private Date timestamp;
	
	public ErrorResponse() {
		super();
	}
	
	public ErrorResponse(String message, String description, int code, Date timestamp) {
		super();
		this.message = message;
		this.description = description;
		this.code = code;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	@Override
	public String toString() {
		return "ErrorResponse [message=" + message + ", description=" + description + ", code=" + code + ", timestamp="
				+ timestamp + "]";
	}
	
}
