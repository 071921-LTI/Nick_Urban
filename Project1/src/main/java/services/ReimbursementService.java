package services;

import java.util.List;

import exceptions.ReimbursementNotFoundException;
import models.Reimbursement;

public interface ReimbursementService {

	Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException;
	
	List<Reimbursement> getReimbursementsByEmployeeId(int id);
	List<Reimbursement> getAllReimbursementsByStatus(String status);
	List<Reimbursement> getEmployeePendingReimbursements(int empId);
	List<Reimbursement> getEmployeeResolvedReimbursements(int empId);
	List<Reimbursement> getReimbursements();
	
	boolean addReimbursement(Reimbursement reimbursement);
	
	//boolean updateReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException; // need this here?
	
	boolean deleteReimbursement(int id) throws ReimbursementNotFoundException;
}
