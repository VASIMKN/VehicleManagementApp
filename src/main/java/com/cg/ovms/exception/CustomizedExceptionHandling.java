package com.cg.ovms.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleExceptions( NotFoundException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());
        response.setErrorMsg("NOT_FOUND");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return entity;
    }
    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<Object> handleExceptions2( DuplicateIdException exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setDateTime(LocalDateTime.now());
        response.setMessage(exception.getMessage());
        response.setErrorMsg("METHOD_FAILURE");
        ResponseEntity<Object> entity = new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
        return entity;
    }
    @ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> handleAlreadyExistsException(AlreadyExistsException e){
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMsg("CONFLICT");
		response.setMessage(e.getMessage());
		response.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(DeletionException.class)
	public ResponseEntity<ExceptionResponse> handleDeletionException(DeletionException e){
		ExceptionResponse response = new ExceptionResponse();
		response.setErrorMsg("CONFLICT");
		response.setMessage(e.getMessage());
		response.setDateTime(LocalDateTime.now());
		
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.CONFLICT);
	}
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<ExceptionResponse> handleException1(NoSuchUserException exception){
		ExceptionResponse response=new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		response.setErrorMsg("NOT FOUND");
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserEmptyException.class)
	public ResponseEntity<ExceptionResponse> handleException2(UserEmptyException exception){
		ExceptionResponse response=new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		response.setErrorMsg("BAD REQUEST");
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	/*ResponseEntity<Object> entity= new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
	return entity;*/
	}

	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<ExceptionResponse> handleException3(DuplicateUserException exception){
		ExceptionResponse response=new ExceptionResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(exception.getMessage());
		response.setErrorMsg("CONFLICT");
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	/*ResponseEntity<Object> entity= new ResponseEntity<Object>(response,HttpStatus.NOT_FOUND);
	return entity;*/
	}
	}
	



