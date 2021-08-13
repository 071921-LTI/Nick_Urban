package com.nick;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nick.models.Reimbursement;

//@TestMethodOrder(OrderAnnotation.class) // add this later?
@ExtendWith(MockitoExtension.class)
public class ReimbursementTest {

	private static Reimbursement reimb;
	
	@BeforeEach
	public static void setUp() {
		reimb = new Reimbursement();
		
	}
	
	@AfterEach
	public static void tearDown() {
		
	}
	
	@Test
	public static void getReimbursementByIdTest() {
		
	}
	
	@Test
	public static void getReimbursementByIdFail() {
		
	}
	
	@Test
	public static void getReimbursementsByEmployeeIdTest() {
		
	}
	
	@Test
	public static void getReimbursementsByEmployeeIdFail() {
		
	}
	
	@Test
	public static void getAllReimbursementsByStatusTest() {
		
	}
	
	@Test
	public static void getAllReimbursementsByStatusFail() {
		
	}
	
	@Test
	public static void getEmployeePendingReimbursementsTest() {
		
	}
	
	@Test
	public static void getEmployeePendingReimbursementsFail() {
		
	}
	
	@Test
	public static void getEmployeeResolvedReimbursementsTest() {
		
	}
	
	@Test
	public static void getEmployeeResolvedReimbursementsFail() {
		
	}
	
	@Test
	public static void getReimbursementsTest() {
		
	}
	
	@Test
	public static void getReimbursementsFail() {
		
	}
	
	@Test
	public static void addReimbursementTest() {
		
	}
	
	@Test
	public static void addReimbursementFail() {
		
	}
	
	@Test
	public static void deleteReimbursementTest() {
		
	}
	
	@Test
	public static void deleteReimbursementFail() {
		
	}
	
	
	
	
	
	
}
