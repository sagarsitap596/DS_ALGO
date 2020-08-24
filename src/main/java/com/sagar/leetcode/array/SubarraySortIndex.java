package com.sagar.leetcode.array;

public class SubarraySortIndex {

	public static void main(String[] args) {

		int[] res = subarraySort2(new int[] { 1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19 });
		System.out.println(res[0] + " , " + res[1]);
	}

	public static int[] subarraySort(int[] array) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int prev = array[0];
		for (int i = 1; i < array.length; i++) {
			if (prev > array[i]) {
				if (array[i] < min)
					min = array[i];
				if (array[i] > max)
					max = array[i];
			} else {
				prev = array[i];
			}
		}
		System.out.println(min);
		System.out.println(max);
		if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE)
			return new int[] { -1, -1 };

		int i = 0;
		int j = array.length - 1;

		// get sorted index of min
		while (i < array.length && array[i] <= min) {
			i++;
		}

		// get sorted index of max
		while (j >= 0 && array[j] > max) {
			j--;
		}
		return new int[] { i, j };
	}

	public static int[] subarraySort2(int[] array) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < array.length; i++) {
			if (!isSorted(i, array[i], array)) {
				if (array[i] < min)
					min = array[i];
				if (array[i] > max)
					max = array[i];
			}
		}
		System.out.println(min);
		System.out.println(max);
		if (min == Integer.MAX_VALUE && max == Integer.MIN_VALUE)
			return new int[] { -1, -1 };

		int i = 0;
		int j = array.length - 1;

		// get sorted index of min
		while (i < array.length && array[i] <= min) {
			i++;
		}

		// get sorted index of max
		while (j >= 0 && array[j] > max) {
			j--;
		}
		return new int[] { i, j };
	}

	static private boolean isSorted(int index, int num, int[] array) {
		if (index == 0)
			return num <= array[index + 1];
		if (index == array.length - 1)
			return array[index - 1] <= num;
		return array[index - 1] <= num && num <= array[index + 1];
	}
}
