package com.nick.daos;

import com.nick.models.ReimbursementType;

public interface ReimbursementTypeDao {
	ReimbursementType getReimbursementTypeByType(String type);
	void addReimbursementType(ReimbursementType reimbursementType);
}
