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
		if(arr[mid] == key) {
			return mid+1;
		}else if(arr[mid] > key) {
			return binarySearch(arr, start, mid, key);
		}else {
			return binarySearch(arr, mid+1, end, key);
		}
		
	}

	public static void main(String[] args) {
		RecursionQuestions recursionObject = new RecursionQuestions();
		// TODO Auto-generated method stub
		int arr[]  = {1,2,2,4,6,8,11,11,12,15,17};
		System.out.print(recursionObject.binarySearch(arr, 0, arr.length, 8));
	}

}
