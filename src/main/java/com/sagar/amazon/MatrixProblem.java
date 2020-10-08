package com.sagar.amazon;

import java.util.ArrayDeque;
import java.util.Queue;

public class MatrixProblem {

	public static void main(String[] args) {
		char[][] mat = { { 'E', 'X', '0', 'X' }, { '0', '0', '0', 'S' }, { '0', '0', '0', '0' } };

		System.out.println(findShortestPath(mat, 1, 3, 'E'));
	}

	// O(n * 8 ) == O(n) == where n is row * cols
	public static int findShortestPath(char[][] matrix, int startRow, int startCol, char endChar) {

		if (matrix.length == 0)
			return -1;
		if (matrix[startRow][startCol] == endChar)
			return 0;

		int[] neighboursRow = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int[] neighboursCol = { 0, 1, 1, 1, 0, -1, -1, -1 };

		Queue<Cell> queue = new ArrayDeque<>();
		queue.offer(new Cell(startRow, startCol));
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		int steps = 0;

		while (!queue.isEmpty()) {

			steps++; // 1 2
			int queueSize = queue.size(); // 4
			while (queueSize > 0) {
				Cell cell = queue.poll();
				visited[cell.row][cell.col] = true;
				for (int k = 0; k < 8; k++) {
					int newRow = cell.row + neighboursRow[k];
					int newCol = cell.col + neighboursCol[k];

					if (newRow >= matrix.length || newCol >= matrix[0].length || newRow < 0 || newCol < 0
							|| matrix[newRow][newCol] == 'X' || visited[newRow][newCol])
						continue;

					if (matrix[newRow][newCol] == endChar) {
						return steps;
					}
					queue.offer(new Cell(newRow, newCol));
				}
				queueSize--;
			}
		}
		return -1;
	}

	static class Cell {
		int row;
		int col;

		Cell(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

}
