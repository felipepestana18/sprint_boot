package com.example.demo.resources.exception;



import java.io.Serializable;

public class Response implements Serializable {

	private static final long serialVersionUID = 1L;


	private String status;
    private Integer statusCode;


	public Response(String status, Integer statusCode) {
		super();
		this.status = status;
		this.statusCode = statusCode;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
