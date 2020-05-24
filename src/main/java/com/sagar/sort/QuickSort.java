package com.sagar.sort;

/**
 * best and avg time complexity is O(N Log N). Worst case is O(N ^ 2).
 * Memory complexity is O(log N)
 * 
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 7, 2, 5, 2, 7, 4, 8, 5, 9, 7, 9, 10 }; // 13 >> 12
		quickSort(arr, 0, arr.length - 1);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}

	}

	private static void quickSort(int[] arr, int first, int last) {
		if (first < last) {
			int splitIndex = getSplitIndex(arr, first, last);
			quickSort(arr, first, splitIndex - 1);
			quickSort(arr, splitIndex + 1, last);
		}
	}

	private static int getSplitIndex(int[] arr, int first, int last) {
		int lower = first + 1;
		int upper = last;
		int pivot = arr[first];
		while (lower < upper) {
			// advance lower while pivot is greater
			while (lower < upper && arr[lower] <= pivot) {
				lower++;
			}

			// advance upper while pivot is less
			while (upper > lower && arr[upper] >= pivot) {
				upper--;
			}

			if (lower > upper) {
				break;
			} else {
				int temp = arr[lower];
				arr[lower] = arr[upper];
				arr[upper] = temp;
			}
		}

		arr[first] = arr[upper];
		arr[upper] = pivot;
		return upper;
	}

}
