package com.example.demo.resources.exception;

public class ObjectNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1;
	
	public ObjectNotFoundException(String msg) {
		super(msg);
	}  
	
	public ObjectNotFoundException(Integer status, String msg, Throwable cause) {
		super(msg, cause);
	}

}
