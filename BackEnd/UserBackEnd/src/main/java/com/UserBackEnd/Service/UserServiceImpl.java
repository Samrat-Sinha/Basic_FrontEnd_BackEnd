package com.UserBackEnd.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UserBackEnd.Exception.UserException;
import com.UserBackEnd.Model.User;
import com.UserBackEnd.Repositary.UserRepositary;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepositary uRepo;
	
	@Override
	public User register(User user) throws UserException {
		Optional<User> findUser = uRepo.findByPhoneNumber(user.getPhoneNumber());
		if(findUser.isPresent()) {
			throw new UserException("User is already Present");
		}
		else {
			return uRepo.save(user);
		}
	}

	@Override
	public List<User> alluser() throws UserException {
		List<User> allUser = uRepo.findAll();
		if(allUser.isEmpty()) {
			throw new UserException("No User Present!!");
		}
		else {
			return allUser;
		}
	}

}
