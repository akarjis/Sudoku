package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		if ( candidateSolution.isEmpty() || candidateSolution.length() != 81) {
			return -1;
		}
		
		return 1;
	}
}
