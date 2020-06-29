package com.sagar.leetcode.array;

import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {

	public static void main(String[] args) {
		System.out.println(moveElementToEnd(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2), 2));

	}

	public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

		int leftIndex = 0;
		int rightIndex = getRightIndex(array.size() - 1, array, toMove);

		while (leftIndex < rightIndex) {
			if (array.get(leftIndex).equals(toMove)) {
				array.set(leftIndex, array.get(rightIndex));
				array.set(rightIndex, toMove);
				leftIndex++;
				rightIndex = getRightIndex(rightIndex, array, toMove);
			} else {
				leftIndex++;
			}

		}
		return array;
	}

	private static int getRightIndex(int rightIndex, List<Integer> array, int toMove) {
		while (rightIndex >= 0 && array.get(rightIndex).equals(toMove)) {
			rightIndex--;
		}
		return rightIndex;
	}

}
