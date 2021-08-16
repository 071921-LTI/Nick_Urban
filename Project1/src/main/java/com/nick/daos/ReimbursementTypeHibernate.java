package com.nick.daos;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nick.models.ReimbursementType;
import com.nick.util.HibernateUtil;

public class ReimbursementTypeHibernate implements ReimbursementTypeDao {

	@Override
	public ReimbursementType getReimbursementTypeByType(String type) {
		ReimbursementType reimbursementType = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM ReimbursementType WHERE type = :type";
			TypedQuery<ReimbursementType> tq = s.createQuery(hql, ReimbursementType.class);
			tq.setParameter("type", type);
			
			reimbursementType = tq.getSingleResult();
		}
		return reimbursementType;
	}

	@Override
	public void addReimbursementType(ReimbursementType reimbursementType) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(reimbursementType);
			tx.commit();
		}
		
	}

}
