package com.nick.services;

import com.nick.models.ReimbursementType;

public interface ReimbursementTypeService {
	ReimbursementType getReimbursementTypeByType(String type);
	void addReimbursementType(ReimbursementType reimbursementType);
}
