package com.nick.driver;

import java.util.List;

import com.nick.exceptions.UserNotFoundException;
import com.nick.models.Reimbursement;
import com.nick.models.ReimbursementStatus;
import com.nick.models.ReimbursementType;
import com.nick.models.User;
import com.nick.models.UserRoles;
import com.nick.services.ReimbursementService;
import com.nick.services.ReimbursementServiceImpl;
import com.nick.services.ReimbursementStatusService;
import com.nick.services.ReimbursementStatusServiceImpl;
import com.nick.services.ReimbursementTypeService;
import com.nick.services.ReimbursementTypeServiceImpl;
import com.nick.services.UserRolesService;
import com.nick.services.UserRolesServiceImpl;
import com.nick.services.UserService;
import com.nick.services.UserServiceImpl;

public class Driver {

	public static void main(String[] args) throws UserNotFoundException {
		
		
		/* 
		 * populates the reimb-status, reimb-type and user-role tables (with hibernate)
		 */
//		ReimbursementStatusService rStatusService = new ReimbursementStatusServiceImpl();
//		ReimbursementStatus rs1 = new ReimbursementStatus("pending");
//		ReimbursementStatus rs2 = new ReimbursementStatus("approved");
//		ReimbursementStatus rs3 = new ReimbursementStatus("denied");
//		rStatusService.addReimbursementStatus(rs1);
//		rStatusService.addReimbursementStatus(rs2);
//		rStatusService.addReimbursementStatus(rs3);
//		
//		ReimbursementTypeService rTypeService = new ReimbursementTypeServiceImpl();
//		ReimbursementType rt1 = new ReimbursementType("lodging");
//		ReimbursementType rt2 = new ReimbursementType("travel");
//		ReimbursementType rt3 = new ReimbursementType("food");
//		ReimbursementType rt4 = new ReimbursementType("other");
//		rTypeService.addReimbursementType(rt1);
//		rTypeService.addReimbursementType(rt2);
//		rTypeService.addReimbursementType(rt3);
//		rTypeService.addReimbursementType(rt4);
//		
		UserRolesService uRoleService = new UserRolesServiceImpl();
//		UserRoles ur1 = new UserRoles("employee");
//		UserRoles ur2 = new UserRoles("manager");
//		uRoleService.addUserRole(ur1);
//		uRoleService.addUserRole(ur2);
		
		/*
		 * adds user(s) to the users table, uses a user-role record 
		 */
		UserService us = new UserServiceImpl();
//		User u1 = new User("nickdev", "pass", "nick", "urban", "nick@mail.com", ur1);
//		us.addUser(u1);
		
		
//		UserRoles ur2 = uRoleService.getUserRoleByRole("manager");
//		User u2 = new User("theboss", "1234", "Chris", "Cornell", "chris@mail.com", ur2);
//		us.addUser(u2);
		
		UserRoles ur2 = uRoleService.getUserRoleByRole("manager");
		User u2 = new User("sub-boss", "1234", "John", "Goodman", "john@mail.com", ur2);
		us.addUser(u2);

//		UserRoles ur3 = uRoleService.getUserRoleByRole("employee");
//		UserService us = new UserServiceImpl();
//		User u3 = new User("robsales", "pass", "rob", "smith", "rob@mail.com", ur3);
//		us.addUser(u3);
		
		/*
		 * adds reimbursement(s) to the reimbursement table, uses a reimb-type and reimb-status records
		 */
//		ReimbursementService rs = new ReimbursementServiceImpl();
//		Reimbursement r1 = new Reimbursement(500.23, "surf and turf dinner", u1, rs1, rt3);
//		rs.addReimbursement(r1);
		
//		UserService us = new UserServiceImpl();
//		User user = us.getUserById(1);
//		System.out.println(user);
//		
//		List<Reimbursement> reimbs = null;
//		ReimbursementService rs = new ReimbursementServiceImpl();
//		reimbs = rs.getReimbursementsByEmployeeId(user);
//		System.out.println(reimbs);
		
	}

}
