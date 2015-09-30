package org.univoulu.tol.sqatlab.sudoku;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		int returnValue = 0;
		// returns 0 if the candidate solution is correct
		int validity = checkValidInput(candidateSolution);
		if (validity == -1)
			return validity;
		
		
		for (int i = 0; i < candidateSolution.length() / 9; i++) {
			returnValue = checkRow(candidateSolution, i);
			if (returnValue != 0)
				break;
		}
		
		return returnValue;
	}
	
	private int checkRow(String candidateSolution, int rowIndex) {		
		int startRead = 0 + (9 * rowIndex);
		int endRead = startRead + 9;
		
		Set<Integer> numSet = createNumberSet();
				
		int ret = 0;
		String row = candidateSolution.substring(startRead, endRead);
		
		for (int i = 0; i < 9; i++) {

			int num = Integer.parseInt(row.substring(i, i+1));			
			boolean success = numSet.remove(num);
			
			if (!success)
				ret = -3;
		}
		
		return ret;
	}
	
	private Set<Integer> createNumberSet() {
		Set<Integer> numSet = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		return numSet;
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
