package com.nick;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.nick.models.User;

//@TestMethodOrder(OrderAnnotation.class) // add this later?
public class UserTest {

	private static User user;
	
	@BeforeAll
	public static void setUp() {
		user = new User();
	}
	
	@AfterAll
	public static void tearDown() {
		
	}
	
	
	@Test
	public static void getUserByIdTest() {
		
	}
	
	@Test
	public static void getUserByUserNameTest() {
		
	}
	
	@Test
	public static void getUsersByRoleTest() {
		
	}
	
	@Test
	public static void getUsersTest() {
		
	}
	
	@Test
	public static void addUserTest() {
		
	}
	
	@Test
	public static void deleteUserTest() {
		
	}
}
