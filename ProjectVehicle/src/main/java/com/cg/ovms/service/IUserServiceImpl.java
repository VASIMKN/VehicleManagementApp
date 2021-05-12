package com.cg.ovms.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ovms.UserExceptions.DuplicateUserException;
import com.cg.ovms.UserExceptions.NoSuchUserException;
import com.cg.ovms.UserExceptions.UserEmptyException;
import com.cg.ovms.entities.User;
import com.cg.ovms.repository.IUserRepository;

@Service
public class IUserServiceImpl implements IUserService {

	Logger log = LoggerFactory.getLogger(IUserService.class);

	@Autowired
	private IUserRepository userRepository;

	@Override
	@Transactional
	public User addUser(User user) throws DuplicateUserException {
		Optional<User> u = userRepository.findById(user.getUserId());
		if (!(u.isEmpty())) {
			throw new DuplicateUserException("Check, it is alredy present ");
		} else {
			log.info("Given Details Saved");
			return userRepository.save(user);

		}
	}

	@Override
	public User removeUser(User user) throws NoSuchUserException {
		// System.out.println(user.getUserId());
		Optional<User> u = userRepository.findById(user.getUserId());
		//log.info(user.toString());
		if (u.isEmpty()) {
			throw new NoSuchUserException("User is not exist");
		} else {
			log.info("Given Details Removed");
			userRepository.delete(user);
			return user;
		}
	}

	@Override
	public User validateUser(User user) {
		// TODO Auto-generated method stub
		User result = userRepository.findByUserIdAndPassword(user.getUserId(), user.getPassword());
		return result;

	}

	/*@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
