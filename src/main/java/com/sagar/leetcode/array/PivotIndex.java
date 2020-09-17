package com.sagar.leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class PivotIndex {

	public static void main(String[] args) {

//		int[] A = { 4, -1, 0, 3 };
//		int[] B = { -2, 5, 0, 3 };

//		int[] A = { 2, -2, -3, 3 };
//		int[] B = { 0, 0, 4, -4 };

//		int[] A = { 4, -1, 0, 3 };
//		int[] B = { -2, 6, 0, 4 };

//		int[] A = { 3, 2, 6 };
//		int[] B = { 4, 1, 6 };

		int[] A = { 1 };
		int[] B = { 1 };
		System.out.println(new PivotIndex().solution(A, B));

	}

	public int solution(int[] A, int[] B) {

		int result = 0;
		long ASum = sum(A);
		long BSum = sum(B);
		Map<Integer, Long> indexSum = getIndexOfEqualSum(A, ASum);

		for (Integer index : indexSum.keySet()) {
			if (isFairIndex(indexSum.get(index), index, B, BSum)) {
				result++;
			}
		}
		return result;
	}

	private boolean isFairIndex(long requiredSum, Integer endIndex, int[] B, long BSum) {

		int currentSum = 0;
		for (int i = 0; i < endIndex; i++) {
			currentSum = currentSum + B[i];
		}
		return (BSum - currentSum) == currentSum && requiredSum == currentSum;

	}

	public Map<Integer, Long> getIndexOfEqualSum(int[] array, long totalSum) {

		Map<Integer, Long> indexSum = new HashMap<>();

		long runningSum = 0;
		for (int i = 0; i < array.length; i++) {
			runningSum = runningSum + array[i];
			if (totalSum - runningSum == runningSum) {
				if (i + 1 < array.length)
					indexSum.put(i + 1, runningSum);
			}
		}
		return indexSum;
	}

	private long sum(int[] array) {
		int totalSum = 0;
		for (int element : array) {
			totalSum = totalSum + element;
		}
		return totalSum;
	}

}
