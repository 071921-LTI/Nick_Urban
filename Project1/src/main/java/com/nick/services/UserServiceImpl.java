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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserName(String userName) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsersByRole(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		ud.addUser(user);
		
	}

	@Override
	public boolean deleteUser(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
