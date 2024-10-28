package com.calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RecursionQuestionsTest {

	@Test
	void lcm_whenTwoNumbersIsPassed_returnLCM() {
		RecursionQuestions recursionQuesObject = new RecursionQuestions();
		
		int number1 = 2;
		int number2 = 18;
		int number3 = 14;
		int number4 = 19;
		
		int expected1 = recursionQuesObject.lcm(number1, number2, 2);
		int expected2 = recursionQuesObject.lcm(number3, number4, 2);
		int expected3 = recursionQuesObject.lcm(number1, number3, 2);
		int expected4 = recursionQuesObject.lcm(number2, number3, 2);
				
		int actual1 = 18;
		int actual2 = 266;
		int actual3 = 14;
		int actual4 = 126;
				
		assertEquals(actual1, expected1);
		assertEquals(actual2, expected2);
		assertEquals(actual3, expected3);
		assertEquals(actual4, expected4);
	}
	
	@Test
	void hcf_whenTwoNumbersIsPassed_returnHCF() {
		RecursionQuestions recursionQuesObject = new RecursionQuestions();

		int number1 = 2;
		int number2 = 18;
		int number3 = 14;
		int number4 = 19;
		
		int expected1 = recursionQuesObject.hcf(number1, number2);
		int expected2 = recursionQuesObject.hcf(number3, number4);
		int expected3 = recursionQuesObject.hcf(number1, number3);
		int expected4 = recursionQuesObject.hcf(number2, number3);
		
		int actual1 = 2;
		int actual2 = 1;
		int actual3 = 2;
		int actual4 = 2;
	   
		assertEquals(actual1, expected1);
		assertEquals(actual2, expected2);
		assertEquals(actual3, expected3);
		assertEquals(actual4, expected4);
    }
	
	
	@Test
	void linearSearch_whenArrayAndKeyIsPassed_returnIndexOfKey() {
		RecursionQuestions recursionQuesObject = new RecursionQuestions();

		int array1[] = {1,0,10,2,9};
		int array2[] = {1,2,3,4,5,3,2,1};
		int array3[] = {10, 12, 14};
		
		int expected1 = recursionQuesObject.linearSearch(array1, 0, 2);
		int expected2 = recursionQuesObject.linearSearch(array2, 0, 5);
		int expected3 = recursionQuesObject.linearSearch(array3, 0, 20);
				
		int actual1 = 4;
		int actual2 = 5;
		int actual3 = -1;
				
		assertEquals(actual1, expected1);
		assertEquals(actual2, expected2);
		assertEquals(actual3, expected3);
	}
	
	@Test
	void binarySearch_whenPassedArrayKeyStartEnd_returnsIndexOfKey(){
		RecursionQuestions recursionQuesObject = new RecursionQuestions();

		int array1[] = {1, 10, 14, 40, 100};
		int array2[] = {1,2,3,4,5};
		int array3[] = {10, 12, 14};
	
		int expected1 = recursionQuesObject.binarySearch(array1, 0, array1.length-1, 10);
		int expected2 = recursionQuesObject.binarySearch(array2, 0, array2.length-1, 5);
		int expected3 = recursionQuesObject.binarySearch(array3, 0, array3.length-1, 20);
			
		int actual1 = 2;
		int actual2 = 5;
		int actual3 = -1;
			
		assertEquals(actual1, expected1);
		assertEquals(actual2, expected2);
		assertEquals(actual3, expected3);
	}
	
	@Test
	void nQueen_whenPassed2DArrayStartingRowDimensionOfMatrix_return() {
		RecursionQuestions recursionQuesObject = new RecursionQuestions();
        	// Test the public nQueens method
        	int array1[][] = new int[4][4];
        	int array2[][] = new int[3][3];
        
        	boolean expected1 = recursionQuesObject.nQueen(array1, 0, array1.length);
        	boolean expected2 = recursionQuesObject.nQueen(array2, 0, array2.length);
        
        	boolean actual1 = true;
        	boolean actual2 = false;
        
        	assertEquals(actual1, expected1);
        	assertEquals(actual2, expected2);
    	}
}

