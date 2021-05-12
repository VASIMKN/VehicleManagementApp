package com.cg.ovms.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.ovms.entities.User;
import com.cg.ovms.repository.IUserRepository;
import com.cg.ovms.service.IUserService;

@SpringBootTest
public class TestingOfUser2 {
@Autowired
private IUserService userService;
@MockBean
private IUserRepository userRepository;
@Test
public void TestAddUser1() {
	User userData = new User("3", "dev", "manager");
	when(userRepository.save(userData)).thenReturn(userData);
	assertEquals(userData, userService.addUser(userData));
}
}