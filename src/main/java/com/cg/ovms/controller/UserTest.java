package com.cg.ovms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.cg.ovms.UserException.DuplicateUserException;
//import com.cg.ovms.UserException.NoSuchUserException;
//import com.cg.ovms.UserException.UserEmptyException;
import com.cg.ovms.entities.User;
import com.cg.ovms.exception.NoSuchUserException;
import com.cg.ovms.exception.UserEmptyException;
import com.cg.ovms.service.IUserService;

@RestController
@RequestMapping("/uservehicle")
public class UserTest {
	Logger log=LoggerFactory.getLogger(UserTest.class);
	@Autowired
	private IUserService userService;

	// Adding User
	// http://localhost:8081/RestUser/uservehicle/adduser
	@PostMapping(path = "/adduser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> addUser(@RequestBody User user) throws UserEmptyException {
		if (user.getUserId().isEmpty() || user.getPassword().isEmpty() || user.getRole().isEmpty())
			throw new UserEmptyException("Check, User fields is empty ");
		User users = userService.addUser(user);
		return new ResponseEntity<User>(users, HttpStatus.OK);
	}

	// Deleting User
	// http://localhost:8081/RestUser/uservehicle/deleteuser
	@DeleteMapping(path = "/deleteuser", consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> removeUser(@RequestBody User user) {
		User users = userService.removeUser(user);
		return new ResponseEntity<User>(users, HttpStatus.OK);
	}

	// Validating User
	// http://localhost:8081/RestUser/uservehicle/uservalid/2k/maha
	@GetMapping(path = "/uservalid/{userId}/{password}")
	public ResponseEntity<String> validateUser(@PathVariable("userId") String userId,
			@PathVariable("password") String password) throws NoSuchUserException {
		User users = new User(userId, password);
		User res = userService.validateUser(users);
		if (res != null) {
			log.info("Given Credentials are valid");
			return new ResponseEntity<String>("Login Credentials are Valid", HttpStatus.OK);
		}
		throw new NoSuchUserException("User credentials are invalid");
	}
}
