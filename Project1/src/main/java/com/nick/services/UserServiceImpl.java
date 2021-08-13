package com.nick.services;

import java.util.List;

import com.nick.daos.UserDao;
import com.nick.daos.UserHibernate;
import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;

public class UserServiceImpl implements UserService {
	
	UserDao ud = new UserHibernate();

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		return ud.getUserById(id);
	}

	@Override
	public User getUserByUserName(String userName) throws UserNotFoundException {
		return ud.getUserByUserName(userName);
	}

	@Override
	public List<User> getUsersByRole(String role) {
		return ud.getUsersByRole(role);
	}

	@Override
	public List<User> getUsers() {
		return ud.getUsers();
	}

	@Override
	public void addUser(User user) {
		ud.addUser(user);
		
	}

	@Override
	public boolean updateUser(User user) throws UserNotFoundException {
		try { // see if updating a user throws an erroer in UserHibernate, if so return false (this should work?)
			
		}
	}
	
	@Override
	public boolean deleteUser(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
