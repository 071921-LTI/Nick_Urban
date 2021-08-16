package com.nick.services;

import com.nick.daos.ReimbursementTypeDao;
import com.nick.daos.ReimbursementTypeHibernate;
import com.nick.models.ReimbursementType;

public class ReimbursementTypeServiceImpl implements ReimbursementTypeService {

	ReimbursementTypeDao rtd = new ReimbursementTypeHibernate();
	
	@Override
	public ReimbursementType getReimbursementTypeByType(String type) {
		return rtd.getReimbursementTypeByType(type);
	}

	@Override
	public void addReimbursementType(ReimbursementType reimbursementType) {
		rtd.addReimbursementType(reimbursementType);
		
	}

}
