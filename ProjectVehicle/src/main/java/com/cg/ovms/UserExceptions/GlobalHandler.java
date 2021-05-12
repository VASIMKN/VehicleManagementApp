package com.cg.ovms.UserExceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.ovms.UserExceptions.ExceptionResponse;
import com.cg.ovms.UserExceptions.NoSuchUserException;
import com.cg.ovms.UserExceptions.UserEmptyException;

@ControllerAdvice
public class GlobalHandler extends ResponseEntityExceptionHandler {

@ExceptionHandler(NoSuchUserException.class)
public ResponseEntity<ExceptionResponse> handleException1(NoSuchUserException exception){
	ExceptionResponse response=new ExceptionResponse();
	response.setDateTime(LocalDateTime.now());
	response.setMessage(exception.getMessage());
	response.setErrorCode("NOT FOUND");
	return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
}

@ExceptionHandler(UserEmptyException.class)
public ResponseEntity<ExceptionResponse> handleException2(UserEmptyException exception){
	ExceptionResponse response=new ExceptionResponse();
	response.setDateTime(LocalDateTime.now());
	response.setMessage(exception.getMessage());
	response.setErrorCode("BAD REQUEST");
	return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
/*ResponseEntity<Object> entity= new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
return entity;*/
}

@ExceptionHandler(DuplicateUserException.class)
public ResponseEntity<ExceptionResponse> handleException3(DuplicateUserException exception){
	ExceptionResponse response=new ExceptionResponse();
	response.setDateTime(LocalDateTime.now());
	response.setMessage(exception.getMessage());
	response.setErrorCode("CONFLICT");
	return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
/*ResponseEntity<Object> entity= new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
return entity;*/
}
}
