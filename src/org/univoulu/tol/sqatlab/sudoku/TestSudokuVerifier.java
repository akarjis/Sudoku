package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {

	SudokuVerifier verifier;

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
		assertEquals(1, ret);
	}
	
	@Test
	public void testVerifyCorrectString() {
		String correctString = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int ret = verifier.verify(correctString);
		assertEquals(0, ret);
	}

}
