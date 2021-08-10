package daos;

import java.util.List;

import exceptions.ReimbursementNotFoundException;
import models.Reimbursement;

public interface ReimbursementDao {
	Reimbursement getReimbursementById(int id) throws ReimbursementNotFoundException;
	
	List<Reimbursement> getReimbursementsByEmployeeId(int id);
	List<Reimbursement> getAllReimbursementsByStatus(String status);
	List<Reimbursement> getEmployeePendingReimbursements(int empId);
	List<Reimbursement> getEmployeeResolvedReimbursements(int empId);
	List<Reimbursement> getReimbursements();
	
	int addReimbursement(Reimbursement reimbursement);
	
	boolean updateReimbursement(Reimbursement reimbursement) throws ReimbursementNotFoundException;
	
	int deleteReimbursement(int id) throws ReimbursementNotFoundException;
	
}
