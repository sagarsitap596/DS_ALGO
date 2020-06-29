package com.sagar.leetcode.array;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class LongestPeak {

	public static void main(String[] args) {
//		int[] a = { 5, 4, 3, 2, 1, 2, 1 };
//		System.out.println(longestPeak(a));
	}

	public static int longestPeak(int[] array) {
		int peak = 1;
		int result = 0;
		boolean isAscending = array[0] < array[1];
		for (int i = 0; i < array.length - 1; i++) {
			if (isAscending && array[i] < array[i + 1]) {
				peak++;
			} else if (array[i] >= array[i + 1]) {
				isAscending = false;
				peak++;
			} else {
				isAscending = true;
				peak++;
				if (result < peak) {
					result = peak;
				}
				peak = 1;
			}
		}
		return Math.max(result, peak) >= 3 ? Math.max(result, peak) : 0;
	}

}
