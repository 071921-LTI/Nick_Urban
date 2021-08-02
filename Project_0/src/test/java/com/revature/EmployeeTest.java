package com.revature;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.revature.models.*;

public class EmployeeTest {

	private Employee emp = new Employee(0, "employee1", "pass", true);
	
	@Test
	public void addItemToShopTest() {
		Item item = new Item("shoes", 80, 0, 0, 0, 0, false, 0);
		ArrayList<Item> items = new ArrayList<Item>();
		
		emp.addItemToShop(items, item);
		
		assertTrue(items.contains(item));
	}
	
	@Test
	public void removeItemFromShopTest() {
		Item item = new Item("shoes", 80, 0, 0, 0, 0, false, 0);
		ArrayList<Item> items = new ArrayList<Item>();
		items.add(item);
		
		emp.removeItemFromShop(items, item);
		
		assertFalse(items.contains(item));
	}
}
