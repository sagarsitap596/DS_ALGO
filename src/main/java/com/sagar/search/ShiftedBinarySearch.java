package com.sagar.search;

public class ShiftedBinarySearch {

	public static void main(String[] args) {

		int[] array = new int[] { 7, 8, 9, 1, 2, 3, 4, 5, 6 };
		System.out.println(shiftedBinarySearch(array, 1));

		System.out.println(shiftedBinarySearch(array, 1, 0, array.length - 1));

	}

	public static int shiftedBinarySearch(int[] array, int target) {

		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (array[mid] == target) {
				return mid;
			}
			if (array[left] < array[mid]) { // left side is sorted
				if (target >= array[left] && target < array[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			} else {
				if (target >= array[mid] && target <= array[right]) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
		}
		return -1;
	}
	//{ 7, 8, 9, 1, 2, 3, 4, 5, 6 };
	public static int shiftedBinarySearch(int[] array, int target, int left, int right) {

		while (left <= right) {
			int middle = (left + right) / 2;
			int potentialMatch = array[middle];
			int leftNum = array[left];
			int rightNum = array[right];
			if (target == potentialMatch) {
				return middle;
			} else if (leftNum <= potentialMatch) {
				if (target >= leftNum && target < potentialMatch) {
					right = middle - 1;
				} else {
					left = middle + 1;
				}
			} else {
				if (target > potentialMatch && target <= rightNum) {
					left = middle + 1;
				} else {
					right = middle - 1;
				}
			}
		}
		return -1;
	}

}
