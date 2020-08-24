package com.sagar.leetcode.array;

public class SubArrayDiff {

	public static void main(String[] args) {

		int[] arr = { 3, 5, 2, 1, 7, 6, 8, 6, 7, 8 };
		System.out.println(isArrayValid2(arr, 3));

	}

	public static int isArrayValid(int[] array, int target) {
		int i = 0;
		int j = 1;
		int max = Integer.MIN_VALUE;
		while (j < array.length) {
			int temp_j = j;
			while (temp_j > i) {
				if (Math.abs(array[temp_j - 1] - array[j]) <= target) {
					temp_j--;
				} else {
					if (max < j - i) {
						max = j - i;
					}
					i = temp_j + 1;
					break;
				}
			}
			j++;
		}
		return max;
	}

	public static int isArrayValid2(int[] array, int target) { // 3, 5, 2, 1, 7, 6, 8, 6, 7, 8
		int max = array[0];
		int min = array[0];
		int i = 0;
		int j = 1;
		int result = 0;
		int sum = 0;
		while (j < array.length) {

			if (min > array[j]) {
				min = array[j];
			}
			if (max < array[j]) {
				max = array[j];
			}
			if (Math.abs(max - min) <= target) {
				sum++;
			} else {
				sum = 0;
				i++;
				continue;
			}
			if (sum > result) {
				result = sum;
			}
			j++;
		}
		return result + 1;
	}

}
