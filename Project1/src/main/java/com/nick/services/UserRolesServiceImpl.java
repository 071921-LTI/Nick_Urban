package com.nick.services;

import com.nick.daos.UserRolesDao;
import com.nick.daos.UserRolesHibernate;
import com.nick.models.UserRoles;

public class UserRolesServiceImpl implements UserRolesService {

	UserRolesDao urd = new UserRolesHibernate();
	
	@Override
	public UserRoles getUserRoleByRole(String role) {
		return urd.getUserRoleByRole(role);
	}

	@Override
	public void addUserRole(UserRoles userRole) {
		urd.addUserRole(userRole);
		
	}

}
