/*******************************************************************************************************
* @classname: RecursionQuestions
* @author: Praroop
* Modification Log:
********************************************************************************************************
* Praroop Kumawat        2024/10/25         Making functions to perform using Recursion
********************************************************************************************************/

package com.calculations;

import java.util.ArrayList;

public class RecursionQuestions {
	/**
	 * calculates the LCM of two numbers
	 * @param num1 
	 * @param num2
	 * @param factor which can divide the numbers
	 * @return lcm int of the two numbers
	 */
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
	/**
	 * calculates the HCF of two numbers using Euclids Theorem
	 * @param num1
	 * @param num2
	 * @return the HCF of two numbers
	 */
	public int hcf(int num1, int num2) {
		if (a == 0){
            		return b;
		}
        return hcf(b % a, a);		
	}
	/**
	 * Searches for the key in the whole array
	 * @param arr Array in which key has to be searched
	 * @param index the starting to iterate on array
	 * @param key the value we are looking for
	 * @return the index at which key is present in array
	 */
	public int linearSearch(int arr[], int index, int key) {
		if(index > arr.length-1) {
			return -1;
		}else if(arr[index] == key) {
			return index + 1;
		}
		return linearSearch(arr, index+1, key);
	}
	/**
	 * searches for key in whole sorted array 
	 * @param arr Array in which key is searched
	 * @param start staring index of array
	 * @param end ending index of array
	 * @param key the value for which we are looking in array
	 * @return the index at which key is present in array
	 */
	public int binarySearch(int arr[], int start, int end, int key) {
		if(start > end) {
			return -1;
		}
		int mid = (end-start)/2 + start;
		if(start==end && arr[end]!=key){
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
	/**
	 * checks if the place where we are placing the queen is safe or not
	 * @param board array in which we are placing the queen
	 * @param row the row in we are placing queen
	 * @param column the column in which we are placing the queen
	 * @return true if queen is not attacked by other queens at that position
	 */
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
	
	/**
	 * if n queens can be arranged on nxn board such that no queen attacks other
	 * @param board array of nxn on which queens have to be arranged
	 * @param row starting row for placing queen
	 * @param dimensionOfMatrix dimensions of board
	 * @return boolean true if possible
	 */
	public boolean nQueen(int [][]board, int row, int dimensionOfMatrix) {
		int count = 0;

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
		if( count > 0) {
			return true;
		}
		return false;
	}
	/**
	 * printing the chess board with arranged queens
	 * @param board array in which queens are arranged
	 */
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
		int[][] board = new int[3][3];
		System.out.println(recursionObject.nQueen(board, 0, board.length));
	}

}
