package com.sagar.amazon;

/**
 * 
 * Time complexity : 5 * (rows * columns). ach cell is travesed 5 times once
 * main loop and 4 times from adj cells Sapce complexity : O(rows * columns)
 * worst case recursive call stack will have all cells (all cells 1)
 * 
 * @author sitapsha
 *
 */
public class NumberOfIsland {

	public static void main(String[] args) {
		NumberOfIsland ni = new NumberOfIsland();

		char[][] mat = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };
		System.out.println(ni.numIslands(mat));

	}

	static int[] rows = { -1, 0, 1, 0 };
	static int[] cols = { 0, 1, 0, -1 };

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[0].length; col++) {
				if (grid[row][col] == '1') {
					count++;
					traverse(row, col, grid);
				}
			}
		}
		return count;
	}

	private void traverse(int row, int col, char[][] grid) {
		grid[row][col] = '2';
		for (int k = 0; k < 4; k++) {
			int newRow = row + rows[k];
			int newCol = col + cols[k];
			if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
					&& grid[newRow][newCol] == '1') {
				traverse(newRow, newCol, grid);
			}
		}
	}

}
