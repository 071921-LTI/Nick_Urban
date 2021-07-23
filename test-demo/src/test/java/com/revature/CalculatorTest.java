package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.exceptions.CalculatorException;

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	/*
	 * JUnit annotations
	 * 	- @BeforeEach
	 * 	- @AfterEach
	 * 	- @BeforeAll
	 * 	- @AfterAll
	 * 	- @Test
	 * 	- @Ignore
	 *  - @Order
	 */
	
	private static Calculator calc;
	
	
	@BeforeAll
	public static void setUp() {
		calc = new Calculator();
	}
	
	@AfterAll
	public static void tearDown() {
	}
	
	@Order(1)
	@Test
	public void addTwoAndTwo() {
		double expected = 4;
		double actualResult = calc.add(2, 2);
		assertEquals(expected, actualResult, "Adding 2 and 2 should be 4");
	}
	
	@Order(2)
	@Test
	public void tenMinusFive() {
		double expected = 5;
		double actualResult = calc.subtract(10, 5);
		assertEquals(expected, actualResult, "10 minus 5 shoud be 5");
	}
	
	@Order(3)
	@Test
	public void fourTimesEight() {
		double expected = 32;
		double actualResult = calc.multiply(4, 8);
		assertEquals(expected, actualResult, "4 times 8 should be 32");
	}
	
	@Order(4)
	@Test
	public void twentyDividedByFour() {
		double expected = 5;
		double actualResult = calc.divide(20, 4);
		assertEquals(expected, actualResult, "20 divided by 4 should be 5");
	}
	
	@Order(5)
	@Test
	public void divideBy0() {
		
		
		assertThrows(CalculatorException.class, () -> calc.divide(1,0));
	}
	
	@Order(6)
	@Test
	public void isPrimeTrue() {
		boolean actualResult = calc.isPrime(89);
		assertTrue(actualResult);
	}
	
	@Order(7)
	@Test
	public void isThreeDecimalTrue() {
		boolean actualResult = calc.compareThreeDecimal(321.123, 321.1237123);
		assertTrue(actualResult);
	}
	
	@Order(7)
	@Test
	public void isThreeDecimalFalse() {
		boolean actualResult = calc.compareThreeDecimal(321.123, 321.120123);
		assertTrue(actualResult == false);
	}
}
