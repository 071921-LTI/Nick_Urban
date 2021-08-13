package com.nick.daos;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;
import com.nick.util.HibernateUtil;


public class UserHibernate implements UserDao {

	@Override
	public User getUserById(int id) throws UserNotFoundException {
		User user = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "from User where id = :userId";
			TypedQuery<User> tq = s.createQuery(hql, User.class);
			tq.setParameter("userId", id);
			
			user = tq.getSingleResult();
		}
		
		return user;
	}

	@Override
	public User getUserByUserName(String userName) throws UserNotFoundException {
		User user = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "from User where userName = :uName";
			TypedQuery<User> tq = s.createQuery(hql, User.class);
			tq.setParameter("uName", userName);
			
			user = tq.getSingleResult();
		}
		
		return user;
	}

	@Override
	public List<User> getUsersByRole(String role) {
		List<User> users = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM User WHERE userRole = :" + role;
			users = s.createQuery(hql, User.class).list();
		}
		
		return users;
	}

	@Override
	public List<User> getUsers() {
		List<User> users = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			users = s.createQuery("FROM User", User.class).list();
		}
		
		return users;
		
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
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(user);
			tx.commit();
		}		
	}

	@Override
	public void deleteUser(User user) throws UserNotFoundException {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(user);
			tx.commit();
		}	
	}

}
