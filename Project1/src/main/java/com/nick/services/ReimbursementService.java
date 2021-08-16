package com.nick.services;

import java.util.List;

import com.nick.exceptions.ReimbursementNotFoundException;
import com.nick.models.Reimbursement;
import com.nick.models.ReimbursementStatus;
import com.nick.models.User;

public interface ReimbursementService {

	Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException;
	
	List<Reimbursement> getReimbursementsByEmployeeId(User user);
	
	List<Reimbursement> getAllReimbursementsByStatus(ReimbursementStatus status);
	
	List<Reimbursement> getEmployeePendingReimbursements(int empId);
	
	List<Reimbursement> getEmployeeResolvedReimbursements(int empId);
	
	List<Reimbursement> getReimbursements();
	
	void addReimbursement(Reimbursement reimbursement);
	
	void updateReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException; // need this here?
	
	void deleteReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException;
}
