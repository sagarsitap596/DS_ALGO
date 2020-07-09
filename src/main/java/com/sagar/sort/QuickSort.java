package com.sagar.sort;

/**
 * best and avg time complexity is O(N Log N). Worst case is O(N ^ 2).
 * Space complexity is in all cases is O(log N)
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

	private static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int splitIndex = getSplitIndex(arr, start, end);
			boolean isLeftArraySmaller = splitIndex - 1 - start < end - splitIndex + 1;
			if (isLeftArraySmaller) {
				quickSort(arr, start, splitIndex - 1);
				quickSort(arr, splitIndex + 1, end);
			} else {
				quickSort(arr, splitIndex + 1, end);
				quickSort(arr, start, splitIndex - 1);
			}
		}
	}

	private static int getSplitIndex(int[] array, int start, int end) {
		int pivot = array[start];
		int left = start + 1;
		int right = end;

		while (left <= right) {
			if (array[left] > pivot && array[right] < pivot) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				// continue; This can also work
			}
			if (array[left] <= pivot) {
				left++;
			}
			if (array[right] >= pivot) {
				right--;
			}
		}

		array[start] = array[right];
		array[right] = pivot;
		return right;
	}

}
