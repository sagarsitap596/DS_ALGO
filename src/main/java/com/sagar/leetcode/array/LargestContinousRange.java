package com.sagar.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class LargestContinousRange {

	public static void main(String[] args) {
		int[] r = largestRange(new int[] { 1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6 });
		System.out.println(r[0]);
		System.out.println(r[1]);

	}

	public static int[] largestRange(int[] array) {

		Map<Integer, Boolean> visited = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			visited.put(array[i], false);
		}

		int rangeStart = 0;
		int rangeEnd = 0;
		for (int i = 0; i < array.length; i++) {
			int leftExtreme = getExremeEnd(array[i], visited, -1);
			int rightExtreme = getExremeEnd(array[i], visited, 1);
			
			if ((rightExtreme - leftExtreme) > ( rangeEnd - rangeStart)) {
				rangeStart = leftExtreme;
				rangeEnd = rightExtreme;
			}
		}

		return new int[] { rangeStart, rangeEnd };
	}

	private static int getExremeEnd(int currentNumber, Map<Integer, Boolean> visited, int inc_dec) {

		if (visited.get(currentNumber))
			return currentNumber;
		
		currentNumber = currentNumber + inc_dec;
		while (visited.containsKey(currentNumber) && !visited.get(currentNumber)) {
			visited.put(currentNumber, true);
			currentNumber = currentNumber + inc_dec;
		}
		return currentNumber + (inc_dec * (-1));
	}

}
