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
				return returnValue;
		}
		
		for (int i = 0; i < candidateSolution.length() / 9; i++) {
			returnValue = checkColumn(candidateSolution, i);
			if (returnValue != 0)
				return returnValue;
		}
		
		for (int i = 0; i < 9; i++) {
			returnValue = checkSubGrid(candidateSolution, i);
			if (returnValue != 0)
				return returnValue;
		}
		
		return returnValue;
	}
	
	public int checkRow(String candidateSolution, int rowIndex) {		
		int startRead = 0 + (9 * rowIndex);
		int endRead = startRead + 9;
		int ret = 0;
		
		String row = candidateSolution.substring(startRead, endRead);
		
		if (!checkValidRow(row)) {
			ret = -3;
		}
		
		return ret;
	}
	
	public int checkColumn(String candidateSolution, int columnIndex) {
		int ret = 0;
		String row = "";
		
		// build string row for column
		for (int i = 0; i < 9; i++){
			row += candidateSolution.charAt(i * 9 + columnIndex);
		}
		
		// now we have row, let's check
		if (!checkValidRow(row)) {
			ret = -4;
		}		
		
		return ret;
	}
	
	public int checkSubGrid(String candidateSolution, int gridIndex) {
		int ret = 0;
		int startRead = 0;
		
		if (gridIndex < 3)
			startRead += (3 * gridIndex);
		else if (gridIndex >= 3 && gridIndex <=5)
			startRead += 27 + (3 * (gridIndex - 3));
		else if (gridIndex >= 6 && gridIndex <=8)
			startRead += 54 + (3 * (gridIndex - 6));
		
		String row = "";
			
		row += candidateSolution.charAt(startRead + 0);
		row += candidateSolution.charAt(startRead + 1);
		row += candidateSolution.charAt(startRead + 2);
		
		row += candidateSolution.charAt(startRead + 9);
		row += candidateSolution.charAt(startRead + 10);
		row += candidateSolution.charAt(startRead + 11);
		
		row += candidateSolution.charAt(startRead + 18);
		row += candidateSolution.charAt(startRead + 19);
		row += candidateSolution.charAt(startRead + 20);
		
		// build string row from sub grid
		
		if (!checkValidRow(row)) {
			ret = -2;
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
	
	private boolean checkValidRow(String rowOfNumbers) {
		boolean ret = true;
		Set<Integer> numSet = createNumberSet();
		
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(rowOfNumbers.substring(i, i+1));			
			boolean success = numSet.remove(num);
			
			if (!success)
				ret = false;
		}		
		return ret;
	}
}
