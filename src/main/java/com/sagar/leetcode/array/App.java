package com.sagar.leetcode.array;

import java.util.Arrays;

public class App {

	static void allLexicographicRecur(String str, char[] data, int last, int index) {
		int length = str.length();

// One by one fix all characters at the given index  
// and recur for the subsequent indexes 
		for (int i = 0; i < 4; i++) {

// Fix the ith character at index and if  
// this is not the last index then  
// recursively call for higher indexes 
			data[index] = str.charAt(i);

// If this is the last index then print  
// the string stored in data[] 
			if (index == last)
				System.out.println(new String(data));
			else
				allLexicographicRecur(str, data, last, index + 1);
		}
	}

// This function sorts input string, allocate memory  
// for data(needed for allLexicographicRecur()) and calls 
// allLexicographicRecur() for printing all permutations 
	static void allLexicographic(String str) {
		int length = str.length();

// Create a temp array that will be used by 
// allLexicographicRecur() 
		char[] data = new char[4];
		char[] temp = str.toCharArray();

// Sort the input string so that we get all  
// output strings in lexicographically sorted order 
		Arrays.sort(temp);
		str = new String(temp);

// Now print all permutaions 
		allLexicographicRecur(str, data, length - 1, 0);
	}

// Driver Code 
	public static void main(String[] args) {
		String str = "AB";
		System.out.printf("All permutations with " + "repetition of %s are: \n", str);
		allLexicographic(str);
	}

}
