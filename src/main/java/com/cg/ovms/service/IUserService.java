package com.cg.ovms.service;
//
import java.util.List;

//import com.cg.ovms.UserException.NoSuchUserException;
import com.cg.ovms.entities.User;

public interface IUserService {
	public User validateUser(User user);

	public User addUser(User user);

	public User removeUser(User user);

	// public User signOut(User user);

}
