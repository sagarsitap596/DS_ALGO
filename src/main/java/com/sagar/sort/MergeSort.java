package com.sagar.sort;

import java.util.Arrays;

/***
 * 
 * The time complexity is O(nLogn) in all good, avg and worst cases.<br>
 * The space complexity of the algorithm is O(n logn) as we're creating
 * temporary. Since at all levels( log n levels) array of size n is created. So
 * its n * log n arrays in every recursive call.
 *
 */
public class MergeSort {

	public static void main(String[] args) {

		int[] main = new int[] { 3, 7, 2, 5, 2, 7, 4, 8, 5, 9, 7, 9, 10 }; // 13 >> 12
		int[] aux = main.clone();

		mergeSort2(main, aux, 0, main.length - 1);

		for (int i = 0; i < main.length; i++) {
			System.out.print(main[i] + "  ");
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

	private static void mergeSort2(int[] main, int[] aux, int start, int end) {

		System.out.println(start + " -- " + end);
		if (start == end)
			return;

		int mid = (start + end) / 2;

		mergeSort2(aux, main, start, mid);
		mergeSort2(aux, main, mid + 1, end);
		
		int i = start;
		int j = mid + 1;
		int k = start;
		while (i <= mid && j <= end) {
			if (aux[i] <= aux[j]) { // consider main array as new array and directly substitute values in that.
				main[k] = aux[i];
				i++;
			} else {
				main[k] = aux[j];
				j++;
			}
			k++;

		}
		while (j <= end) {
			main[k] = aux[j];
			k++;
			j++;
		}
		while (i <= mid) {
			main[k] = aux[i];
			k++;
			i++;
		}

	}
}