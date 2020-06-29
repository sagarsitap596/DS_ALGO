package com.sagar.leetcode.array;

public class MaxSubArraySum {

	public static void main(String[] args) {
		int[] array = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(getMaxSubArraySum(array));

	}

	private static int getMaxSubArraySum(int[] array) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum = sum + array[i];
			// if number iteself is greated than the sum than. use that number as individual
			// candidate and start fresh from that number again
			if (array[i] > sum) {
				sum = array[i];
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}

		return maxSum;

	}
	
	

}
