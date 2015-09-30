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
		assertNotEquals(0, ret);
	}

}
