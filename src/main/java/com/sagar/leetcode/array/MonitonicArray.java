package com.sagar.leetcode.array;

public class MonitonicArray {

	public static void main(String[] args) {
		
		int a =5;
		int b =2;
		System.out.println(Math.ceil(a/b));
		int[] array = new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
		System.out.println(isMonotonic(array));

	}

	public static boolean isMonotonic(int[] array) {
		if (array.length <= 2)
			return true;
		int direction = array[0] - array[1];

		for (int i = 0; i < array.length - 1; i++) {
			if (direction == 0) {
				direction = array[i] - array[i + 1];
				continue;
			}

			int diff = array[i] - array[i + 1];
			if (direction > 0 && diff >= 0) {
				continue;
			} else if (direction < 0 && diff <= 0) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}
	
	

}
