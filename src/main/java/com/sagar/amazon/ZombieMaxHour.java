package com.sagar.amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZombieMaxHour {

	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };

	public static void main(String[] args) {

		int[][] mat = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		System.out.println(findNumberOfHour(mat));

	}

	// Total time complexity : O(rows * cols)
	// space complexity : O(rows * cols)
	public static int findNumberOfHour(int[][] mat) {

		int totalSteps = 0;

		// space = O(rows * cols) worst case all are rotten so all will go in queue.
		Queue<Index> newZombies = new ArrayDeque<Index>();

		// time : O(rows * cols)
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[0].length; col++) {
				if (mat[row][col] == 1) {
					newZombies.add(new Index(row, col, 0));
					totalSteps = 0;
				}
			}
		}

		while (!newZombies.isEmpty()) {
			Index index = newZombies.poll();

			for (int k = 0; k < 4; k++) {
				int newRow = index.row + rows[k];
				int newCol = index.col + cols[k];
				if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
						&& mat[newRow][newCol] == 0) {
					mat[newRow][newCol] = 1;
					newZombies.add(new Index(newRow, newCol, index.step + 1));
					totalSteps = index.step + 1;
					System.out.println("(" + index.row + "," + index.col + ")" + "  >>  (" + newRow + "," + newCol + ")"
							+ " >> " + totalSteps);
				}
			}
		}

		// time : O(rows * cols)
		for (int row = 0; row < mat.length; row++) {
			for (int col = 0; col < mat[0].length; col++) {
				if (mat[row][col] == 0) {
					return -1;
				}
			}
		}
		return totalSteps;
	}

	static class Index {
		int row;
		int col;
		int step;

		public Index(int row, int col, int step) {
			this.row = row;
			this.col = col;
			this.step = step;
		}
	}

}
