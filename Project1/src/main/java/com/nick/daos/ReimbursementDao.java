package com.nick.daos;

import java.util.List;

import com.nick.exceptions.ReimbursementNotFoundException;
import com.nick.models.Reimbursement;

public interface ReimbursementDao {
	Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException;
	
	List<Reimbursement> getReimbursementsByEmployeeId(int id);
	List<Reimbursement> getAllReimbursementsByStatus(String status);
	List<Reimbursement> getEmployeePendingReimbursements(int empId);
	List<Reimbursement> getEmployeeResolvedReimbursements(int empId);
	List<Reimbursement> getReimbursements();
	
	Reimbursement addReimbursement(Reimbursement reimbursement);
	
	void updateReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException;
	
	void deleteReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException;
	
}
