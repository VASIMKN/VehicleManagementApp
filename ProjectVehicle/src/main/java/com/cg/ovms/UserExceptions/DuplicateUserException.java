package com.cg.ovms.UserExceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class DuplicateUserException extends RuntimeException {
public DuplicateUserException(String message) {
	super(message);
}
}
