package com.nick.services;

import java.util.List;

import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;

public interface UserService {
	User getUserById(int id) throws UserNotFoundException;
	
	User getUserByUserName(String userName) throws UserNotFoundException;
	
	List<User> getUsersByRole(String role);
	
	List<User> getUsers();
	
	void addUser(User user);
	
	void updateUser(User user) throws UserNotFoundException; 
	
	void deleteUser(User user) throws UserNotFoundException;
}
