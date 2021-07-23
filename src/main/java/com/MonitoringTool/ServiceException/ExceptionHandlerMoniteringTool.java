package com.MonitoringTool.ServiceException;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerMoniteringTool {

	@ExceptionHandler(serviceException.class)
	public ResponseEntity<?> handleserviceException(serviceException s, WebRequest w){
		errorMessage message = new errorMessage(new Date(), s.getErrorMessage(), s.getErrorCode());
		return new ResponseEntity(message, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> handleEntityNotFoundException(EntityNotFoundException s, WebRequest w){
		errorMessage message = new errorMessage(new Date(), s.getMessage(),"710");
		return new ResponseEntity(message, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleException(Exception s, WebRequest w){
		errorMessage message = new errorMessage(new Date(), s.getMessage(),"800");
		return new ResponseEntity(message, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(BusinessException s, WebRequest w){
		errorMessage message = new errorMessage(new Date(), s.getMessage(), s.getErroCode());
		return new ResponseEntity(message, HttpStatus.BAD_GATEWAY);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleBusinessException(MethodArgumentNotValidException s, WebRequest w){
		errorMessage message = new errorMessage(new Date(), s.getBindingResult().getFieldError().getDefaultMessage().toString(), "801");
		return new ResponseEntity(message, HttpStatus.BAD_GATEWAY);
	}
}
