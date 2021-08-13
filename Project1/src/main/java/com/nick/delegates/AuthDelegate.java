package com.nick.delegates;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nick.exceptions.UserNotFoundException;
import com.nick.models.User;
import com.nick.services.AuthService;
import com.nick.services.AuthServiceImpl;

public class AuthDelegate implements Delegatable {

	// add the corresponding service(s) implementation here (to be used in the methods)
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
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePut in: " + this.getClass());
		
	}

	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePost in: " + this.getClass());	
		
		String username = rq.getParameter("username");
		String password = rq.getParameter("password");
		
		try {
			User user = as.login(username, password);
			if (user != null) {
				
				String token = user.getId() + ":" + user.getUserRole();
				rs.setHeader("Authorization", token);
				rs.setStatus(200);
			} else {
				// ???
			}
		} catch (UserNotFoundException e) {
			rs.sendError(404);
		}
	}

	@Override
	public void handleDelete(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handleDelete in: " + this.getClass());		
	}
}
