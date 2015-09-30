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
		assertEquals(-11, ret);
	}
	
	@Test
	public void testVerifyCorrectStringFormat() {
		String correctString = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
		int ret = verifier.verify(correctString);
		assertNotEquals(-1, ret);
	}

}
