package com.nick.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;
import com.nick.util.HibernateUtil;


public class UserHibernate implements UserDao {

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
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(user);
			tx.commit();
		}		
	}

	@Override
	public void updateUser(User user) throws UserNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
	}

}
