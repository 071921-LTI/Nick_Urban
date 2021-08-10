package services;

import exceptions.UserNotFoundException;
import models.User;

public interface AuthService {
	User login(String username, String password) throws UserNotFoundException;
	boolean authorize(String token) throws UserNotFoundException;
}
