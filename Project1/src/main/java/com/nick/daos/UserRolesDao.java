package com.nick.daos;

import com.nick.models.UserRoles;

public interface UserRolesDao {
	UserRoles getUserRoleByRole(String role);
	void addUserRole(UserRoles userRole);
}
