package com.nick.daos;

import java.util.List;

import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;

public interface UserDao {
	
	User getUserById(int id) throws UserNotFoundException;
	User getUserByUserName(String userName) throws UserNotFoundException;
	List<User> getUsersByRole(String role);
	
	List<User> getUsers();
	
	int addUser(User user);
	
	boolean updateUser(User user) throws UserNotFoundException;
	
	int deleteUser(int id) throws UserNotFoundException;
	

}
