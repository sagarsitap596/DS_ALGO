package com.sagar.leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class RegionLength {

	public static void main(String[] args) {
		List<Integer> heights = new ArrayList<>();
		heights.add(1);
		heights.add(2);
//		heights.add(2);
		heights.add(1);

		System.out.println(calculateTotalRegion(heights));

		int[] array = { 1, 2, 1 };
		System.out.println(caculateRegionLength(array));

	}

	public static long calculateTotalRegion(List<Integer> heights) {

		Map<Integer, Long> indexRegionLength = new HashMap<>();
		long totalRegionLength = 0;
		for (int i = 0; i < heights.size(); i++) {

			indexRegionLength.put(i, caculateRegionLength(i, heights, indexRegionLength));
			totalRegionLength = totalRegionLength + indexRegionLength.get(i);
		}
		return totalRegionLength;
	}

	private static long caculateRegionLength(int index, List<Integer> heights, Map<Integer, Long> indexRegionLength) {
		long regionLength = 1;
		int height = heights.get(index);
		int i = index - 1;

		if (index > 0 && heights.get(index - 1) == heights.get(index)) {
			return indexRegionLength.get(index - 1);
		}
		if (index > 0 && heights.get(index - 1) < heights.get(index)) {
			// traverse left
			while (i >= 0) {
				if (height >= heights.get(i)) {
					regionLength++;
					i--;
				} else {
					break;
				}
			}
		}

		// traverse right
		i = index + 1;
		while (i < heights.size()) {
			if (height >= heights.get(i)) {
				regionLength++;
				i++;
			} else {
				break;
			}
		}
		return regionLength;
	}

	// 1 2 2 1
	private static long caculateRegionLength(int[] array) {

		int[] onRight = nextGreaterOnRight(array);
		int[] onLeft = nextGreaterOnLeft(array);
		long totalRegionLength = 0;
		for (int i = 0; i < array.length; i++) {
			totalRegionLength = totalRegionLength + ((onRight[i] - onLeft[i] - 1));
		}
		return totalRegionLength;
	}

	private static int[] nextGreaterOnRight(int[] array) {
		int[] result = new int[array.length];

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < array.length; i++) {
			while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
				result[stack.pop()] = i;
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			result[stack.peek()] = array.length;
			stack.pop();
		}

		return result;
	}

	private static int[] nextGreaterOnLeft(int[] array) {
		int[] result = new int[array.length];

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = array.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
				result[stack.pop()] = i;
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			result[stack.peek()] = -1;
			stack.pop();
		}

		return result;
	}

}
