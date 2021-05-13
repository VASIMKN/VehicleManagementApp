package com.cg.ovms.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

//import com.cg.ovms.UserExceptions.DuplicateUserException;
//import com.cg.ovms.UserExceptions.NoSuchUserException;
import com.cg.ovms.entities.User;
import com.cg.ovms.exception.DuplicateUserException;
import com.cg.ovms.exception.NoSuchUserException;
import com.cg.ovms.repository.IUserRepository;
import com.cg.ovms.service.IUserService;

@SpringBootTest
public class TestingOfUser {
@Autowired
IUserService userService;
@Autowired
IUserRepository userRepository;

@Test
public void TestAddUser() {
	User users=new User();
	users.setUserId("678912");
	users.setPassword("roshini");
	users.setRole("assistant4");
	User u=userService.addUser(users);
	User u1=userRepository.findById("678912").get();
	assertEquals(u.getUserId(),u1.getUserId());
}
@Test
void testDuplicateUserhouldThrowDuplicateUserException() throws DuplicateUserException {
	assertThrows(DuplicateUserException.class, ()->{
		User users = new User("678", "devi", "assistant");
		userService.addUser(users);
	});
}
@Test
void testNoSuchUserhouldThrowNoSuchUserException() throws NoSuchUserException {
	assertThrows(NoSuchUserException.class, ()->{
		User users = new User("94", "devi", "assistant");
		userService.removeUser(users);
	});
}
@Test
public void TestValidateUser() {
	User users=new User();
	users.setUserId("675");
	users.setPassword("durga");
	User u=userService.validateUser(users);
	User u1=userRepository.findById("675").get();
	assertEquals(u.getUserId(),u1.getUserId());
}
}
