package com.nick.services;

import com.nick.daos.ReimbursementStatusDao;
import com.nick.daos.ReimbursementStatusHibernate;
import com.nick.models.ReimbursementStatus;

public class ReimbursementStatusServiceImpl implements ReimbursementStatusService {

	ReimbursementStatusDao rsd = new ReimbursementStatusHibernate();
	
	@Override
	public ReimbursementStatus getReimbursementStatusByStatus(String status) {
		return rsd.getReimbursementStatusByStatus(status);
	}

	@Override
	public void addReimbursementStatus(ReimbursementStatus reimbursementStatus) {
		rsd.addReimbursementStatus(reimbursementStatus);
		
	}

}
