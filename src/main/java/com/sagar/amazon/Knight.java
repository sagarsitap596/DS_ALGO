package com.sagar.amazon;

import java.util.Arrays;

public class Knight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Knight k = new Knight();
		System.out.println(k.minMoves(7, 6, 6, 0, 1));

	}

	/*
	 * Complete the 'minMoves' function below.
	 *
	 * The function is expected to return an INTEGER. The function accepts following
	 * parameters: 1. INTEGER n 2. INTEGER startRow 3. INTEGER startCol 4. INTEGER
	 * endRow 5. INTEGER endCol
	 */

	static int[] neighbourRows = { -1, 1, 2, 2, 1, -1, -2, -2 };
	static int[] neighbourcols = { 2, 2, 1, -1, -2, -2, -1, 1 };

	public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
		Integer[][] moves = new Integer[n][n];

		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves.length; j++) {
				moves[i][j] = Integer.MAX_VALUE;
			}
		}
		fillMatrix(n, endRow, endCol, moves, -1);
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < moves.length; j++) {
				System.out.print("  " + moves[i][j]);
			}
			System.out.println();
		}

		return moves[startCol][endRow] == Integer.MAX_VALUE ? 0 : moves[startCol][startCol];
	}

	private static void fillMatrix(int n, int row, int col, Integer[][] moves, int runningSteps) {

		if (isValidCell(n, row, col)) {
			if (moves[row][col] > runningSteps + 1) {
				moves[row][col] = runningSteps + 1;
				for (int k = 0; k < 8; k++) {
					fillMatrix(n, row + neighbourRows[k], col + neighbourcols[k], moves, runningSteps + 1);
				}
			}
		}
	}

	private static void findDestination(int n, int startRow, int startCol, int endRow, int endCol, boolean[][] visited,
			int runningSteps, MinSteps minSteps) {

		if (isValidCell(n, startRow, startCol) && !visited[startRow][startCol]) {
			runningSteps++;
			if (startRow == endRow && startCol == endCol) {
				if (runningSteps < minSteps.count) {
					System.out.println(minSteps.count + "   " + runningSteps);
					minSteps.count = runningSteps;
					return;
				}
			}
			visited[startRow][startCol] = true;
			for (int k = 0; k < 8; k++) {
				findDestination(n, startRow + neighbourRows[k], startCol + neighbourcols[k], endRow, endCol, visited,
						runningSteps, minSteps);
			}
		}
	}

	private static boolean isValidCell(int n, int row, int col) {
		return row >= 0 && row < n && col >= 0 && col < n;
	}

	static class MinSteps {
		int count = Integer.MAX_VALUE;
	}

}
