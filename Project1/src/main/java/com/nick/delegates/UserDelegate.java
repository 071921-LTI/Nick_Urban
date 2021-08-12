package com.nick.delegates;

import java.io.IOException;
import java.io.InputStream;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nick.models.Reimbursement;
import com.nick.models.User;
import com.nick.services.UserService;
import com.nick.services.UserServiceImpl;

public class UserDelegate implements Delegatable {

	// add the corresponding service(s) implementation here (to be used in the methods)
	UserService us = new UserServiceImpl();
	
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
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePut in: " + this.getClass());		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePost in: " + this.getClass());	
		
		InputStream request = rq.getInputStream();
		
		//User user = new ObjectMapper().readValue(request, User.class);
		User user = new User("rick", "pass", "nick", "urban", "nick@mail", 1);
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
