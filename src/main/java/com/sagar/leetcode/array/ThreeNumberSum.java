package com.sagar.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Write a function that takes in a non-empty array of distinct integers and an
integer representing a target sum. The function should find all triplets in
the array that sum up to the target sum and return a two-dimensional array of
all these triplets. The numbers in each triplet should be ordered in ascending
order, and the triplets themselves should be ordered in ascending order with
respect to the numbers they hold.

If no three numbers sum up to the target sum, the function should return an
empty array.

Input
array = [12, 3, 1, 2, -6, 5, -8, 6]   , sum = 0

Output
[[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
*/
public class ThreeNumberSum {

	public static void main(String[] args) {
		List<Integer[]> l = threeNumberSum(new int[] { 12, 3, 1, 2, -6, 5, -8, 6 }, 0);
		l.stream().forEach(arr -> {
			System.out.print("[ ");
			for (Integer val : arr) {
				System.out.print(val + " ");
			}
			System.out.println(" ]");
		});

	}

	public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

		List<Integer[]> result = new ArrayList<>();
		Arrays.sort(array);
		for (int p1 = 0; p1 < array.length; p1++) {
			int newTarget = targetSum - array[p1];

			// for this newTarget apply two number sum logic
			int i = p1 + 1;
			int j = array.length - 1;
			while (i < j) {
				if (array[i] + array[j] == newTarget) {
					result.add(new Integer[] { array[p1], array[i], array[j] });
					i++;
					j--;
				} else if (array[i] + array[j] > newTarget) {
					j--;
				} else {
					i++;
				}
			}
		}
		return result;
	}
}
