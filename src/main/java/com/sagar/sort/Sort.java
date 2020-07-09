package com.sagar.sort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Sort {

	public static void main(String[] args) {

		File file = new File(Sort.class.getClassLoader().getResource("sort.in").getFile());
		try (FileReader reader = new FileReader(file); BufferedReader br = new BufferedReader(reader)) {

//			Long n = Long.parseLong(br.readLine().trim());
//			long[] array = Arrays.stream(br.readLine().trim().split(" ")).mapToLong(Long::parseLong).toArray();

			long[] array = { 6, 5, 4, 3, 2, 1 };
			// bubbleSort(array);
			// selectionSort(array);
			insertionSort(array);
			print(array);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void print(long[] array) {

		Arrays.stream(array).forEach(n -> System.out.print(n + " "));
		System.out.println();
	}

	/**
	 * Higher value goes to end at each iteration
	 * 
	 * Best = O(n) due to isSorted flag
	 * Average and worst  = O(n^2)
	 */
	public static void bubbleSort(long[] array) {

		for (int i = 0; i < array.length - 1; i++) { // we will sort n-1 elements (Automatically remaining one element
			boolean isSorted = true;                                  // will be sorted position)
			for (int j = 0; j < array.length - 1 - i; j++) { // for each iteration highest value will go to end. so we
																// don't need check them again. thats why length-1-i
				if (array[j] > array[j + 1]) {
					long temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			if(isSorted){ // id no swap is done means array is sorted. Optimization
				break;
			}
		}
	}

	/**
	 * select smallest from all the elements and swap with current index
	 * 
	 * best , Avg and besst : O(n^2)
	 */
	public static void selectionSort(long[] array) {

		// for every position of i. swap with smallest element from i th to last element
		for (int i = 0; i < array.length - 1; i++) {
			int minIdx = i;
			for (int j = i+1; j < array.length; j++) {
				if (array[minIdx] > array[j]) {
					minIdx = j;
				}
			}
			long temp = array[i];
			array[i] = array[minIdx];
			array[minIdx] = temp;
		}
	}

	/**
	 * places current index element into appropriate plcae in sorted 0th to
	 * currentIdx -1 array.
	 * 
	 * 
	 * Best case :  O(n)
	 * Avg and besst : O(n^2)
	 */
	public static void insertionSort(long[] array) {
		for (int currentIdx = 1; currentIdx < array.length; currentIdx++) {
			long val = array[currentIdx];
			int idx = currentIdx;
			while (idx > 0 && val < array[idx - 1]) {
				array[idx] = array[idx - 1]; // Shift higher val down
				idx--;
			}
			array[idx] = val;
		}
	}
	
	
	
	
	
}
