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
		assertEquals(-1, ret);
	}
	
	@Test
	public void testVerifyCorrectStringLength() {
		String tooShortString = "41736982563215894795872431682543716979158643234691275828964357157329168416487529";
		int ret = verifier.verify(tooShortString);
		assertEquals(-1, ret);
		String tooLongString = "41736982563215894795872431682543716979158643234691275828964357157329168416487529234234";
		ret = verifier.verify(tooLongString);
		assertEquals(-1, ret);
	}
	
	@Test void testVerifyNoNegativeOrZeroValues() {
		String negativeValuesString = "-4173698256321589479587243168254371697915864323469127582896435715732916841648752923";
		int ret = verifier.verify(negativeValuesString);
		assertEquals(-1, ret);
		
		String zeroValuesString = "0173698256321589479587243168254371697915864323469127582896435715732916841648752923";
		ret = verifier.verify(zeroValuesString);
		assertEquals(-1, ret);
	}

}
