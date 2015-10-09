package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {

	private SudokuVerifier verifier;
	private String correctString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	private String incorrectString = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

	@Before
	public void setUp() {
		verifier = new SudokuVerifier();
	}
	
	@After
	public void tearDown() {
		verifier = null;
	}
	
	@Test
	public void testVerifyFailEmptyString() {
		int ret = verifier.verify("");
		assertEquals(-1, ret);
	}
	
	@Test
	public void testVerifyCorrectStringLength() {
		String tooShortString = correctString.substring(0, 80);
		int ret = verifier.verify(tooShortString);
		assertEquals(-1, ret);
		String tooLongString = (correctString += 1);
		ret = verifier.verify(tooLongString);
		assertEquals(-1, ret);
	}
	
	@Test 
	public void testVerifyNoNegativeOrZeroValues() {
		String negativeValuesString = "-17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int ret = verifier.verify(negativeValuesString);
		assertEquals(-1, ret);
		
		String zeroValuesString = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
		ret = verifier.verify(zeroValuesString);
		assertEquals(-1, ret);
	}

	@Test
	public void testCorrectString() {
		int ret = verifier.verify(correctString);
		assertEquals(0, ret);
	}
	
	@Test
	public void testRowsCorrectString() {
		int ret;
		for (int i = 0; i < 9; i++) {
			ret = verifier.checkRow(correctString, i);
			assertEquals(0, ret);
		}
	}
	
	@Test
	public void testRowsIncorrectString() {
		int ret;
		for (int i = 0; i < 9; i++) {
			ret = verifier.checkRow("111111111222222222333333333444444444555555555666666666777777777888888888999999999", i);
			assertEquals(-3, ret);
		}
	}
	
	@Test
	public void testColumsPass() {
		int ret;
		for (int i = 0; i < 9; i++) {
			ret = verifier.checkColumn(correctString, i);
			assertEquals(0, ret);
		}
	}
	
	@Test
	public void testColumnsIncorrectString() {
		int ret;
		for (int i = 0; i < 9; i++) {
			ret = verifier.checkColumn("123456789123456789123456789123456789123456789123456789123456789123456789123456789", i);
			assertEquals(-4, ret);
		}
	}
	
	@Test
	public void testIncorrectString() {
		int ret = verifier.verify(incorrectString);
		assertNotEquals(0, ret);
	}
	
	@Test void testCorrectSubGrid() {
		int ret = verifier.checkSubGrid(correctString, 0);
		assertEquals(0, ret);
	}
	
	@Test
	public void testIncorrectSubGrid() {
		int ret = verifier.checkSubGrid(incorrectString, 0);
		assertNotEquals(0, ret);
	}
}
