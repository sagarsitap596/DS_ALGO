package com.sagar.searching;

public class ThreeGreatest {

	public static void main(String[] args) {
		int[] r = findThreeLargestNumbers(new int[] { 141, 1, 17, -7, 17, -27, 18, 541, 8, 7, 7 });
		System.out.println(r[0]);
		System.out.println(r[1]);
		System.out.println(r[2]);
	}

	public static int[] findThreeLargestNumbers(int[] array) {
		int[] result = new int[3];
		result[0] = Integer.MIN_VALUE;
		result[1] = Integer.MIN_VALUE;
		result[2] = Integer.MIN_VALUE;

		// [ 1, 17, 141]
		for (int i = 0; i < array.length; i++) {
			int element = array[i];
			if (element > result[0]) {
				if (element < result[1]) {
					result[0] = element;
				} else if (element < result[2]) {
					result[0] = result[1];
					result[1] = element;
				} else {
					result[0] = result[1];
					result[1] = result[2];
					result[2] = element;
				}
			}
		}
		return result;
	}

}
