package com.nick.services;

import com.nick.models.ReimbursementStatus;

public interface ReimbursementStatusService {
	ReimbursementStatus getReimbursementStatusByStatus(String status);
	void addReimbursementStatus(ReimbursementStatus reimbursementStatus);
}
