package com.calculations;

import java.util.ArrayList;

public class RecursionQuestions {
	
	public int lcm(int num1, int num2, int factor) {
		int lcmValue = 1;
		if(num1 == 1 && num2 == 1) {
			return 1;
		}
		if ( num1 % factor == 0 && num2 % factor == 0) {
			lcmValue = lcmValue * factor * lcm(num1/factor, num2/factor, factor);
		} else if ( num1 % factor == 0 && num2 % factor !=0 ) {
			lcmValue = lcmValue * factor * lcm(num1/factor, num2, factor);
		} else if ( num1 % factor != 0 && num2 % factor == 0 ) {	
			lcmValue = lcmValue * factor * lcm(num1, num2/factor, factor);
		} else {
			lcmValue *= lcm(num1, num2, ++factor);			
		}
		
		return lcmValue;
	}
	
	public int hcf(int num1, int num2) {
		int hcfValue=1;
		ArrayList<Integer> num1Factor = new ArrayList<>();
		ArrayList<Integer> num2Factor = new ArrayList<>();
		num1Factor = findFactors(num1, 2);
		num2Factor = findFactors(num2, 2);
		
		for(int i=0; i<num1Factor.size(); i++) {
			for(int j=0; j< num2Factor.size(); j++) {
				if(num1Factor.get(i) == num2Factor.get(i)) {
					num2Factor.set(j, null);
					hcfValue *= num1Factor.get(i);
				}
			}
		}
		return hcfValue;
		
	}
	
	public ArrayList<Integer> findFactors(int num, int factor){
		ArrayList<Integer> factorList = new ArrayList<>();
		if(num == 1) {
			return factorList;
		}
		if ( num%factor == 0 ) {
			factorList.add(factor);
			findFactors( num/factor, factor);
		}else {
			findFactors( num, ++factor);
		}
		return factorList;
	}
	
	public int linearSearch(int arr[], int index, int key) {
		if(index > arr.length-1) {
			return -1;
		}else if(arr[index] == key) {
			return index + 1;
		}
		return linearSearch(arr, index+1, key);
	}
	
	public int binarySearch(int arr[], int start, int end, int key) {
		if(start > end) {
			return -1;
		}
		int mid = (end-start)/2 + start;
		if(start==mid && arr[mid]!=key){
			return -1;
		}
		if(arr[mid] == key) {
			return mid+1;
		}else if(arr[mid] > key) {
			return binarySearch(arr, start, mid, key);
		}else {
			return binarySearch(arr, mid+1, end, key);
		}
	}
	
	public boolean isSafe(int board[][], int row, int column) {
		//vertical up
		for ( int i = row-1; i >= 0; i-- ) {
			if ( board[i][column] == 1 ) {
				return false;
			}
		}
		//diagonal left up
		for ( int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j-- ) {
			if ( board[i][j] == 1 ) {
				return false;
			}
		}
		//diagonal right up
		for ( int i = row - 1, j = column + 1; i >= 0 && j < board.length; i--, j++) {
			if ( board[i][j] == 1 ) {
				return false;
			}
		}
		return true;
	}
	
	static int count = 0;
	
	public boolean nQueen(int [][]board, int row, int dimensionOfMatrix) {
		if ( row == dimensionOfMatrix ) {
			count++;
			printChessBoard(board);
			return true;
		}
		//column loop
		for ( int j = 0; j < dimensionOfMatrix; j++) {
			if ( isSafe(board, row, j )) {
				board[row][j] = 1;
				nQueen(board, row+1, dimensionOfMatrix); // function call
				board[row][j] = 0;						 // backtracking step
			}
		}	
		return false;
	}
	
	public void printChessBoard(int[][] board) {
		System.out.println("-----chess board-----");
		for ( int i = 0; i < board.length; i++) {
			for ( int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
		
		

	public static void main(String[] args) {
		RecursionQuestions recursionObject = new RecursionQuestions();
		// TODO Auto-generated method stub
		int[][] board = new int[11][11];
		if ( recursionObject.nQueen(board, 0, 11)) {
			System.out.println(" SOLUTION IS POSSIBLE ");
			recursionObject.printChessBoard(board);
		} else {
			System.out.println("Total number of solutions are : " + count);
		}
	}

}
