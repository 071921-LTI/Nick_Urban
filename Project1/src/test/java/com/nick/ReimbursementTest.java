package com.nick;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.nick.models.Reimbursement;

//@TestMethodOrder(OrderAnnotation.class) // add this later?
public class ReimbursementTest {

	private static Reimbursement reimb;
	
	@BeforeAll
	public static void setUp() {
		reimb = new Reimbursement();
	}
	
	@AfterAll
	public static void tearDown() {
		
	}
	
	@Test
	public static void getReimbursementByIdTest() {
		
	}
	
	@Test
	public static void getReimbursementsByEmployeeIdTest() {
		
	}
	
	@Test
	public static void getAllReimbursementsByStatusTest() {
		
	}
	
	@Test
	public static void getEmployeePendingReimbursementsTest() {
		
	}
	
	@Test
	public static void getEmployeeResolvedReimbursementsTest() {
		
	}
	
	@Test
	public static void getReimbursementsTest() {
		
	}
	
	@Test
	public static void addReimbursementTest() {
		
	}
	
	@Test
	public static void deleteReimbursementTest() {
		
	}
	
	
	
	
	
	
}
