package com.nick.delegates;

import java.io.IOException;
import com.nick.exceptions.UserNotFoundException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nick.models.Reimbursement;
import com.nick.models.User;
import com.nick.models.UserRoles;
import com.nick.services.AuthService;
import com.nick.services.AuthServiceImpl;
import com.nick.services.UserService;
import com.nick.services.UserServiceImpl;
//import com.revature.exceptions.UserNotFoundException;

public class UserDelegate implements Delegatable {

	// add the corresponding service(s) implementation here (to be used in the methods)
	UserService us = new UserServiceImpl();
	AuthService as = new AuthServiceImpl();
	
	@Override
	public void process(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		String method = rq.getMethod();

		switch (method) {
		case "GET":
			handleGet(rq, rs);
			break;
		case "POST":
			handlePost(rq, rs);
			break;
		case "PUT":
			handlePut(rq, rs);
			break;
		case "DELETE":
			handleDelete(rq, rs);
			break;
		default:
			rs.sendError(405);
		}
		
	}

	@Override
	public void handleGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handleGet in: " + this.getClass());	
		
		String pathInfo = rq.getPathInfo();
		System.out.println(pathInfo);
//		String pathNext = (String) rq.getAttribute("pathNext"); // maybe change pathNext back to pathInfo ??
//		System.out.println("PATHNEXT VALUE: " + pathNext);

		/*
		 * meaning it's not just /users
		 */
		if (pathInfo != null) { 
			// convert the id received to an int
			//int id = Integer.parseInt(pathInfo.substring(1)); // old way (that doesn't seem to work)
			int id = Integer.parseInt(pathInfo.substring(pathInfo.length()-1));
			System.out.println("ID: " + id);
			try (PrintWriter pw = rs.getWriter()) {
				// retrieve the user with the passed-in id
				User user = us.getUserById(id);
				// "write the user to the response body"
				rs.setStatus(200);
				pw.write(new ObjectMapper().writeValueAsString(user));
			} catch (UserNotFoundException e) {
				// if no user with that id is found, return a 404
				rs.sendError(404);
			}
		} else {
			// "protecting" an endpoint with authorization logic, making sure that a user is authenticated before proceeding further.
			String authToken = rq.getHeader("Authorization");
			try {
				if(authToken == null || !as.authorize(authToken)) {
					rs.sendError(403);
				}else {
					/*
					 * for /users endpoint, returning all users
					 */
					List<User> users = us.getUsers();
					try (PrintWriter pw = rs.getWriter()) {
						pw.write(new ObjectMapper().writeValueAsString(users));
					}
				}
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePut in: " + this.getClass());	
		
		InputStream request = rq.getInputStream();
		User userNewInfo = new ObjectMapper().readValue(request, User.class);
		
		System.out.println(userNewInfo);
		
		try {
			User originalUser = us.getUserById(userNewInfo.getId());
			//System.out.println(originalUser);
			
			userNewInfo.setUserRole(originalUser.getUserRole());
			
			// uncomment when ready
			us.updateUser(userNewInfo);
		} catch (UserNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		try {
//			us.updateUser(userNewInfo);
//		} catch (UserNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePost in: " + this.getClass());	
		
		InputStream request = rq.getInputStream();
		
		User user = new ObjectMapper().readValue(request, User.class);
//		UserRoles newRole = new UserRoles("cook");
//		User user = new User("newguy", "pass", "new", "guy", "newguy@mail.com", newRole); // remake this to fit with new constructor (this is just for fake-testing)
		try {
			us.addUser(user);
			rs.setStatus(201);
		} catch (RollbackException e) {
			rs.sendError(400, "Unable to add Reimbursement.");
		}
		
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handleDelete in: " + this.getClass());		
	}
	
}
