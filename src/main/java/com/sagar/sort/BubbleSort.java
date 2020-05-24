package com.sagar.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

		/*
		 * Sort n-2 elements so last element will automatically sort.
		 */
		for (int i = 0; i < arr.length - 1; i++) {
			/**
			 * At every iteration push largest number to the end Since every iteration last
			 * numers are stored we can skip those indexes.
			 */
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			for (int k = 0; k < arr.length; k++) {
				System.out.print(arr[k] + " ");
			}
			System.out.println();
		}
	}
}
