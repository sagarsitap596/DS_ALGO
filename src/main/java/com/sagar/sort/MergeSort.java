package com.sagar.sort;

import java.util.Arrays;

/***
 * 
 * The time complexity is O(nLogn) in all good, avg and worst cases.<br>
 * The space complexity of the algorithm is O(n) as we're creating temporary
 * arrays in every recursive call.
 *
 */
public class MergeSort {

	public static void main(String[] args) {

		int[] arr = new int[] { 3, 7, 2, 5, 2, 7, 4, 8, 5, 9, 7, 9, 10 }; // 13 >> 12
		mergeSort(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public static void mergeSort(int[] a) {
		if (a.length > 1) {
			int mid = a.length / 2;
			int[] l = new int[mid];
			int[] r = new int[a.length - mid];

			// fill left array
			for (int i = 0; i < mid; i++) {
				l[i] = a[i];
			}
			for (int j = mid; j < a.length; j++) {
				r[j - mid] = a[j];
			}
			mergeSort(l);
			mergeSort(r);

			int i = 0; // left array counter
			int j = 0; // right array counter
			int k = 0; // original/input array array counter

			while (i < l.length && j < r.length) {
				if (l[i] <= r[j]) {
					a[k++] = l[i++];
				} else {
					a[k++] = r[j++];
				}
			}
			while (i < l.length) {
				a[k++] = l[i++];
			}
			while (j < r.length) {
				a[k++] = r[j++];
			}
		}
	}
}