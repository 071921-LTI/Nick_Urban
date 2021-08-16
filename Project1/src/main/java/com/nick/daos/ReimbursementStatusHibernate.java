package com.nick.daos;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nick.models.ReimbursementStatus;
import com.nick.util.HibernateUtil;

public class ReimbursementStatusHibernate implements ReimbursementStatusDao {

	@Override
	public ReimbursementStatus getReimbursementStatusByStatus(String status) {
		ReimbursementStatus reimbursementStatus = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()) {
			String hql = "FROM ReimbursementStatus WHERE status = :status";
			TypedQuery<ReimbursementStatus> tq = s.createQuery(hql, ReimbursementStatus.class);
			tq.setParameter("status", status);
			
			reimbursementStatus = tq.getSingleResult();
		}
		
		return reimbursementStatus;
	}

	@Override
	public void addReimbursementStatus(ReimbursementStatus reimbursementStatus) {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(reimbursementStatus);
			tx.commit();
		}
		
	}

}
