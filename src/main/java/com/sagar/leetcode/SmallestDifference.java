package com.sagar.leetcode;

import java.util.Arrays;

/*
Write a function that takes in two non-empty arrays of integers, finds the
pair of numbers (one from each array) whose absolute difference is closest to
zero, and returns an array containing these two numbers, with the number from
the first array in the first position.

You can assume that there will only be one pair of numbers with the smallest
  difference.

 a1 = [-1, 5, 10, 20, 28, 3]
 a2 = [26, 134, 135, 15, 17]
  
 output =  [28, 26]
*/
public class SmallestDifference {

	public static void main(String[] args) {

		int[] a1 = new int[] { 10, 1000 };
		int[] a2 = new int[] { -1441, -124, -25, 1014, 1500, 660, 410, 245, 530 };

		int[] r = smallestDifference(a1, a2);

		System.out.println(r[0] + " , " + r[1]);

	}

	public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		int idxOne = 0;
		int idxTwo = 0;
		int[] result = new int[2];
		int diff = Integer.MAX_VALUE;
		while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
			if (arrayOne[idxOne] < arrayTwo[idxTwo]) {
				if (arrayTwo[idxTwo] - arrayOne[idxOne] < diff) {
					diff = arrayTwo[idxTwo] - arrayOne[idxOne];
					result = new int[] { arrayOne[idxOne], arrayTwo[idxTwo] };
				}
				idxOne++;
			} else if (arrayOne[idxOne] > arrayTwo[idxTwo]) {
				if (arrayOne[idxOne] - arrayTwo[idxTwo] < diff) {
					diff = arrayOne[idxOne] - arrayTwo[idxTwo];
					result = new int[] { arrayOne[idxOne], arrayTwo[idxTwo] };
				}
				idxTwo++;
			} else {
				return new int[] { arrayOne[idxOne], arrayTwo[idxTwo] };
			}
		}
		return result;
	}

}
