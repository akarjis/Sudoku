package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		int validity = checkValidInput(candidateSolution);
		if (validity == -1)
			return validity;
		
		
		int returnValue = checkRow(candidateSolution, 1);
		
		return 1;
	}
	
	private int checkRow(String candidateSolution, int rowNumber) {
		int ret = 0;
		String row = candidateSolution.substring(0, 8);
		
		for (char c : row.toCharArray()) {
			
		}
		
		return ret;
	}
	
	
	/**
	 * Checks if input is valid
	 * @param candidateSolution 
	 * @return 0 if input is valid and ready to be compared, -1 if invalid
	 */
	private int checkValidInput(String candidateSolution) {
		if ( candidateSolution.isEmpty() || candidateSolution.length() != 81) {
			return -1;
		}
		
		if ( candidateSolution.contains("0") || candidateSolution.contains("-")) {
			return -1;
		}
		return 0;
	}
}
