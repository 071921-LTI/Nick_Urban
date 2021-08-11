package com.nick.services;

import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;

public interface AuthService {
	User login(String username, String password) throws UserNotFoundException;
	boolean authorize(String token) throws UserNotFoundException;
}
