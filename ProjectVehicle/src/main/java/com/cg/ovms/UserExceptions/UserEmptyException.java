package com.cg.ovms.UserExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class UserEmptyException extends RuntimeException {
public UserEmptyException(String message) {
	super(message);
}
}
