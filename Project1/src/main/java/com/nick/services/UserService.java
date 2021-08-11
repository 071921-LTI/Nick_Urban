package com.nick.services;

import java.util.List;

import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;

public interface UserService {
	User getUserById(int id) throws UserNotFoundException;
	User getUserByUserName(String userName) throws UserNotFoundException;
	List<User> getUsersByRole(String role);
	List<User> getUsers();
	
	boolean addUser(User user);
	
	//boolean updateUser(User user) throws UserNotFoundException; // need this here?
	
	boolean deleteUser(int id) throws UserNotFoundException;
}
