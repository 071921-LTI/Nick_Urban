package com.nick.daos;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nick.exceptions.ReimbursementNotFoundException;
import com.nick.models.Reimbursement;
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
	public List<Reimbursement> getReimbursementsByEmployeeId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getEmployeePendingReimbursements(int empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reimbursement> getEmployeeResolvedReimbursements(int empId) {
		// TODO Auto-generated method stub
		return null;
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
