package com.nick.services;

import java.util.List;

import com.nick.daos.ReimbursementDao;
import com.nick.daos.ReimbursementHibernate;
import com.nick.exceptions.ReimbursementNotFoundException;
import com.nick.models.Reimbursement;
import com.nick.models.ReimbursementStatus;
import com.nick.models.User;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	ReimbursementDao rd = new ReimbursementHibernate();

	@Override
	public Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException {
		return rd.getReimbursementById(id);
	}

	@Override
	public List<Reimbursement> getReimbursementsByEmployeeId(User user) {
		return rd.getReimbursementsByEmployeeId(user);
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByStatus(ReimbursementStatus status) {
		return rd.getAllReimbursementsByStatus(status);
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
		return rd.getReimbursements();
	}

	@Override
	public void addReimbursement(Reimbursement reimbursement) {
		rd.addReimbursement(reimbursement);
	}

	@Override
	public void updateReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException {
		rd.updateReimbursement(reimbursement);
		
	}
	
	@Override
	public void deleteReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException {
		rd.deleteReimbursement(reimbursement);
	}

	
	
}
