package com.nick.daos;

import java.util.List;

import com.nick.exceptions.ReimbursementNotFoundException;
import com.nick.models.Reimbursement;
import com.nick.models.ReimbursementStatus;
import com.nick.models.User;

public interface ReimbursementDao {
	Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException;
	
	List<Reimbursement> getReimbursementsByEmployeeId(User user);
	
	List<Reimbursement> getAllReimbursementsByStatus(ReimbursementStatus status);
	
	public List<Reimbursement> getEmployeeReimbursementsByStatus(User user, ReimbursementStatus status);
	
	List<Reimbursement> getReimbursements();
	
	Reimbursement addReimbursement(Reimbursement reimbursement);
	
	void updateReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException;
	
	void deleteReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException;
	
}
