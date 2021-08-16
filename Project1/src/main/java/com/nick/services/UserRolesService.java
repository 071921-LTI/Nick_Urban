package com.nick.services;

import com.nick.models.UserRoles;

public interface UserRolesService {
	UserRoles getUserRoleByRole(String role);
	void addUserRole(UserRoles userRole);
}
