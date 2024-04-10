package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Calculation;

public class CalculationTest {
	
	//arrange
	private Calculation calculation;
	
	//before every unit test case, this method will run automatically
	@Before
	public void initialize() {
		calculation = new Calculation();
	}

	@After
	public void tearDown() {
		calculation = null;
	}
	
	@Test
	public void testAdd() {	
		//act
		int actualResult = calculation.add(12, 13);
		int exepectedResult = 25;
		
		//assert
		assertEquals(exepectedResult, actualResult);
	}
	
	@Test
	public void testDivide() {		
		int actualResult = calculation.divide(12, 3);
		int exepectedResult = 4;
		assertEquals(exepectedResult, actualResult);
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDivideForException() {
		calculation.divide(12, 0);
	}
}
