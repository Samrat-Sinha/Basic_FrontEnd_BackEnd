package com.UserBackEnd.Service;

import java.util.List;

import com.UserBackEnd.Exception.UserException;
import com.UserBackEnd.Model.User;

public interface UserService {

	public User register(User user)throws UserException; 
	
	public List<User> alluser()throws UserException; 
}
