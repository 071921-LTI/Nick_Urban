package com.nick.services;

import com.nick.daos.UserDao;
import com.nick.daos.UserHibernate;
import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;

public class AuthServiceImpl implements AuthService {
	
	UserDao ud = new UserHibernate();

	@Override
	public User login(String username, String password) throws UserNotFoundException {
		User user = ud.getUserByUserName(username); // add this behavior in UserHibernate class
		if (user.getPassWord().equals(password)) {
			return user;
		}
		else {
			return null;
		}
	}

	@Override
	public boolean authorize(String token) throws UserNotFoundException {
		String[] stringArr = token.split(":");
		int id = Integer.parseInt(stringArr[0]);
		String role = stringArr[1];
			User user = ud.getUserById(id);
			if(!user.getUserRole().equals(role)) {
				return false;
			} else {
				return true;
			}
	}

}
