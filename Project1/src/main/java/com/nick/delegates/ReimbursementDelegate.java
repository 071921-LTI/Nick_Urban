package com.nick.delegates;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nick.exceptions.ReimbursementNotFoundException;
import com.nick.exceptions.UserNotFoundException;
import com.nick.models.Reimbursement;
import com.nick.models.ReimbursementStatus;
import com.nick.models.ReimbursementType;
import com.nick.models.User;
import com.nick.services.AuthService;
import com.nick.services.AuthServiceImpl;
import com.nick.services.ReimbursementService;
import com.nick.services.ReimbursementServiceImpl;
import com.nick.services.ReimbursementStatusService;
import com.nick.services.ReimbursementStatusServiceImpl;
import com.nick.services.ReimbursementTypeService;
import com.nick.services.ReimbursementTypeServiceImpl;
import com.nick.services.UserService;
import com.nick.services.UserServiceImpl;

public class ReimbursementDelegate implements Delegatable {

	// add the corresponding service(s) implementation here (to be used in the methods)
	ReimbursementService reimS = new ReimbursementServiceImpl();
	ReimbursementStatusService reimStatS = new ReimbursementStatusServiceImpl();
	ReimbursementTypeService reimTypeS = new ReimbursementTypeServiceImpl();
	UserService userS = new UserServiceImpl();
	AuthService authS = new AuthServiceImpl();
	
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
		
		String pathNext = (String) rq.getAttribute("pathNext");
		System.out.println("PATHNEXT VALUE: " + pathNext);
		
		if (pathNext != null) {
			
			
			
			List<Reimbursement> reimbursements = null; 
			
			User user = new User();
			try {
				user = userS.getUserById(Integer.valueOf(pathNext));
				//System.out.println("USER: " + user);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			reimbursements = reimS.getReimbursementsByEmployeeId(user);
			PrintWriter pw = rs.getWriter();
			pw.write(new ObjectMapper().writeValueAsString(reimbursements));
			
		} else if (pathNext == null) {
			//System.out.println("in else block of reimb delegate handle-get");
			List<Reimbursement> reimbursements = null;
			reimbursements = reimS.getReimbursements();
			PrintWriter pw = rs.getWriter();
			pw.write(new ObjectMapper().writeValueAsString(reimbursements));
			
		}
		
		
		
		
		
	}

	@Override
	public void handlePut(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePut in: " + this.getClass());	
		
		String token = rq.getHeader("Authorization");
		//System.out.println("TOKEN: " + token);
		//System.out.println("ID STRING FROM TOKEN: " +token.charAt(0));
		char idChar =  token.charAt(0);
		
		int idFromToken = Integer.parseInt(String.valueOf(idChar));
		//System.out.println(idFromToken);
		
		
		User resolver = null;
		try {
			resolver = userS.getUserById(idFromToken);
		} catch (UserNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//System.out.println("RESOLVER RETRIEVED: " + resolver);
		
		
		InputStream request = rq.getInputStream();
		
		Reimbursement reimbNewStatus = new ObjectMapper().readValue(request, Reimbursement.class);
		
		//System.out.println("UDATED REIMB INFO: " + reimbNewStatus);
		
		try {
			
			// update resolve date
			// update manager resolver name
			// update status
			
			Reimbursement originalReimbursement = reimS.getReimbursementById(reimbNewStatus.getId());
			//System.out.println("TARGET REIMB: " + originalReimbursement);
			
			Date rawDate = new Date();
			Timestamp reimbResolveDate = new Timestamp(rawDate.getTime());
			
			ReimbursementStatus extractedStatus = reimbNewStatus.getStatus();
			String newStatusString = extractedStatus.getStatus();
			ReimbursementStatus newStatus = reimStatS.getReimbursementStatusByStatus(newStatusString);
			//System.out.println("NEW STATUS: " + newStatus);
			//ReimbursementStatus updatedStatus = reimStatS.getReimbursementStatusByStatus();
			
			originalReimbursement.setResolveDate(reimbResolveDate);
			originalReimbursement.setResolver(resolver);
			originalReimbursement.setStatus(newStatus);
			
			System.out.println(originalReimbursement);
			
			reimS.updateReimbursement(originalReimbursement);
			
		} catch (ReimbursementNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// add new reimbursement
	@Override
	public void handlePost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
		System.out.println("in handlePost in: " + this.getClass());
		
		String token = rq.getHeader("Authorization");
		int userId = Integer.parseInt(token.split(":")[0]);
		
		
		
		User reimbAuthor = new User();
		
		try {
			reimbAuthor = userS.getUserById(userId);
			
		} catch (UserNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Date rawDate = new Date();
		Timestamp reimbSubmitDate = new Timestamp(rawDate.getTime());

		ReimbursementStatus pendingStatus = reimStatS.getReimbursementStatusByStatus("pending");
		
		
		
		InputStream request = rq.getInputStream();
		Reimbursement reimbursement = new ObjectMapper().readValue(request, Reimbursement.class);
		
		ReimbursementType reimbType = reimbursement.getType();
		String reimbTypeString = reimbType.getType();
		
		reimbursement.setAuthor(reimbAuthor);
		reimbursement.setSubmitDate(reimbSubmitDate);
		reimbursement.setStatus(pendingStatus);
		
		
		reimbursement.setType(reimTypeS.getReimbursementTypeByType(reimbTypeString));
		
		System.out.println("the reimbursement: " + reimbursement);
		
		
		try {
			
			reimS.addReimbursement(reimbursement);
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
