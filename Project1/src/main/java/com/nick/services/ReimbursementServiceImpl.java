package com.nick.services;

import java.util.List;

import com.nick.daos.ReimbursementDao;
import com.nick.daos.ReimbursementHibernate;
import com.nick.exceptions.ReimbursementNotFoundException;
import com.nick.models.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	ReimbursementDao rd = new ReimbursementHibernate();

	@Override
	public Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addReimbursement(Reimbursement reimbursement) {
		rd.addReimbursement(reimbursement);
	}

	@Override
	public boolean deleteReimbursement(int id) throws ReimbursementNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
