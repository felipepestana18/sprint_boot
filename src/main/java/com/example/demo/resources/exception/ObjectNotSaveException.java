package com.example.demo.resources.exception;

public class ObjectNotSaveException extends RuntimeException{
	
	private static final long serialVersionUID = 1;
	
	public ObjectNotSaveException(String msg) {
		super(msg);
	}  
	
	public ObjectNotSaveException(Integer status, String msg, Throwable cause) {
		super(msg, cause);
	}

}
