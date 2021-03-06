package com.nick.daos;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

//import javax.persistence.Query;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.nick.exceptions.ReimbursementNotFoundException;
import com.nick.models.Reimbursement;
import com.nick.models.ReimbursementStatus;
import com.nick.models.User;
import com.nick.util.HibernateUtil;


public class ReimbursementHibernate implements ReimbursementDao {

	@Override
	public Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException {
		Reimbursement r = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			r = s.get(Reimbursement.class, id);
		}
		return r;
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmployeeId(User user) {
		List<Reimbursement> reimbursements = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			
			String hql = "FROM Reimbursement WHERE author = :user";
			Query<Reimbursement> query = s.createQuery(hql);
			query.setParameter("user", user);
			
			reimbursements = query.list();

		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByStatus(ReimbursementStatus status) {
		List<Reimbursement> reimbursements = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			Query q = s.createQuery("FROM Reimbursement WHERE status = :status" );
			q.setParameter("status", status);
			reimbursements = q.list();
		}
		return reimbursements;
	}

	@Override
	public List<Reimbursement> getEmployeeReimbursementsByStatus(User user, ReimbursementStatus status) {
		List<Reimbursement> reimbursements = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()) {
			Query q = s.createQuery("FROM Reimbursement WHERE status = :status AND user = :user" ); // is the AND correct?
			reimbursements = q.list();
		}
		return reimbursements;
	}


	@Override
	public List<Reimbursement> getReimbursements() {
		List<Reimbursement> reimbursements = null;
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			// Use the classname that been mapped, not the table name
			reimbursements = s.createQuery("FROM Reimbursement", Reimbursement.class).list();
		}
		return reimbursements;
	}

	@Override
	public Reimbursement addReimbursement(Reimbursement reimbursement) {
		Date submitDate = new Date();
		Timestamp ts = new Timestamp(submitDate.getTime());
		reimbursement.setSubmitDate(ts);

		//reimbursement.setStatus(____); // do this here ??
		
		
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.save(reimbursement);
			tx.commit();
		}
		return reimbursement; // maybe remove this and make return-type void ?
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.update(reimbursement);
			tx.commit();
		}
	}

	@Override
	public void deleteReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException {
		try(Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = s.beginTransaction();
			s.delete(reimbursement);
			tx.commit();
		}	
	}
}
