package com.sagar.searching;

public class RotatedSortedArray {

	public static void main(String[] args) {

		int[] array = { 3, 1 };
		int s = 9;

		for (int i = 1; i < 10; i++) {
			System.out.println(search(array, 1));
		}

	}

	private static boolean search(int[] array, int s) {
		int left = 0;
		int right = array.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (array[mid] == s) {
				return true;
			}
			if (array[0] <= array[mid]) {
				if (array[left] <= s && s < array[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (s > array[mid] && s <= array[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}

			}
		}
		return false;
	}

}
