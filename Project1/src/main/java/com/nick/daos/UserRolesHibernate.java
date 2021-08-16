package com.nick.daos;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nick.models.UserRoles;
import com.nick.util.HibernateUtil;

public class UserRolesHibernate implements UserRolesDao {

	@Override
	public UserRoles getUserRoleByRole(String role) {
		UserRoles ur = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM UserRoles WHERE userRole = :uRole";
			TypedQuery<UserRoles> tq = s.createQuery(hql, UserRoles.class);
			tq.setParameter("uRole", role);
			
			ur = tq.getSingleResult();
		}
		
		return ur;
	}

	@Override
	public void addUserRole(UserRoles userRole) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			Transaction tx = s.beginTransaction();
			s.save(userRole);
			tx.commit();
		}
		
	}

}
