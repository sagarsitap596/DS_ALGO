package com.sagar.leetcode.array;

import java.util.Stack;

public class MaxWeigthPath {

	public static void main(String[] args) {

		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 },
				{ 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 },
				{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 }, { 4, 5, 6 },
				{ 7, 8, 9 } };
		Result result = new Result();

		long t = System.currentTimeMillis();

		traverseToDestination(0, 0, A, 0, result);
		System.out.println(result.maxPath);
		System.out.println(System.currentTimeMillis() - t);
		t = System.currentTimeMillis();
		System.out.println(findMaxWeightedPath(A));
		System.out.println(System.currentTimeMillis() - t);

	}

	// recursion
	private static void traverseToDestination(int row, int col, int[][] A, int runningSum, Result result) {

		if (row < A.length && col < A[0].length) {
			String currentPath = result.runningPath + "" + A[row][col];
			int currentSum = runningSum + A[row][col];
			if (currentSum > result.maxSum) {
				result.maxSum = currentSum;
				result.maxPath = currentPath;
			}
			result.runningPath = currentPath;
			traverseToDestination(row, col + 1, A, currentSum, result);
			result.runningPath = currentPath;
			traverseToDestination(row + 1, col, A, currentSum, result);
		}
	}

	static class Result {
		String maxPath = "";
		String runningPath = "";
		int maxSum;
	}

	// iterative DP
	// first calculate maxPath till to reach taht nide
	private static String findMaxWeightedPath(int[][] matrix) {

		Data[][] datamatrix = new Data[matrix.length][matrix[0].length];

		datamatrix[0][0] = new Data(matrix[0][0], -1, -1);

		for (int row = 0; row < datamatrix.length; row++) {
			for (int col = 0; col < datamatrix[0].length; col++) {
				int leftWeight = getWeight(row, col - 1, datamatrix) + matrix[row][col];
				int upWeight = getWeight(row - 1, col, datamatrix) + matrix[row][col];
				if (leftWeight > upWeight) {
					datamatrix[row][col] = new Data(leftWeight, row, col - 1);
				} else {
					datamatrix[row][col] = new Data(upWeight, row - 1, col);
				}
			}
		}

		Stack<Integer> stack = new Stack<>();

		int row = matrix.length - 1;
		int col = matrix[0].length - 1;

		while (row >= 0 && col >= 0) {
			stack.push(matrix[row][col]);
			int[] next = datamatrix[row][col].fromNode;
			row = next[0];
			col = next[1];
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}

	private static int getWeight(int row, int col, Data[][] datamatrix) {
		if (row >= 0 && col >= 0) {
			return datamatrix[row][col].weight;
		}
		return 0;
	}

	static class Data {
		int weight;
		int[] fromNode;

		Data(int weight, int row, int col) {
			this.weight = weight;
			this.fromNode = new int[] { row, col };
		}
	}

}
