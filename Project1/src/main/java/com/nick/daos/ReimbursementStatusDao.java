package com.nick.daos;

import com.nick.models.ReimbursementStatus;

public interface ReimbursementStatusDao {
	ReimbursementStatus getReimbursementStatusByStatus(String status);
	void addReimbursementStatus(ReimbursementStatus reimbursementStatus);
}
