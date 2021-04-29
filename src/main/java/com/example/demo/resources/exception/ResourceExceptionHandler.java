package com.example.demo.resources.exception;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotfound(ObjectNotFoundException e, HttpServletRequest request) {
		StandardError err = new StandardError(400, "Não encontrado");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
	
	@ExceptionHandler(ObjectNotSaveException.class)
	public ResponseEntity<StandardError> ObjectNotSave(ObjectNotFoundException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(400, "Erro de validação");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
