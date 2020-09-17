package com.sagar.leetcode.metrix;

import java.util.LinkedList;
import java.util.Queue;

public class FindPath {

	static int[] rows = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] cols = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void main(String[] args) {
		FindPath f = new FindPath();
//		int[][] mat = new int[][] { { 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 1, 1 }, { 1, 0, 1, 1, 0, 0 },
//				{ 0, 0, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0, 0 } };

		int[][] mat = new int[][] { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };

		System.out.println(shortestPathBinaryMatrixBFS(mat));
//		System.out.println(f.shortestPathBinaryMatrixDFS(mat));

	}

	public int shortestPathBinaryMatrixDFS(int[][] grid) {
		int[][] visited = new int[grid.length][grid[0].length];
		ShortestPath sp = new ShortestPath();
		DFS(0, 0, grid, visited, sp);
		System.out.println(sp.shortestPath);
		return sp.smallestLength == Integer.MAX_VALUE ? -1 : sp.smallestLength;
	}

	public static int shortestPathBinaryMatrixBFS(int[][] grid) {
		int[][] visited = new int[grid.length][grid[0].length];
		ShortestPath sp = new ShortestPath();
		int n = BFS(grid, visited, sp);
		System.out.println(sp.shortestPath);
		return n;
	}

	public void DFS(int row, int col, int[][] grid, int[][] visited, ShortestPath sp) {

		if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] == 0
				&& visited[row][col] == 0) {

			if (row == grid.length - 1 && col == grid[0].length - 1) {
				if (sp.smallestLength > sp.currentLength) {
					sp.shortestPath = sp.currentPath + "--(" + row + "," + col + ")";
					sp.smallestLength = sp.currentLength;
				}
				return;
			}
			String currentPath = sp.currentPath;
			int currentLength = sp.currentLength;
			visited[row][col] = 1;
			for (int neighbour = 0; neighbour < 8; neighbour++) {
				sp.currentPath = currentPath + "--(" + row + "," + col + ")";
				sp.currentLength = currentLength + 1;
				DFS(row + rows[neighbour], col + cols[neighbour], grid, visited, sp);
				sp.currentPath = currentPath;
				sp.currentLength = currentLength;
			}
			visited[row][col] = 0; // backtracking. Since another path can have same node and that patha may be
									// smallest.
		}
	}

	static class ShortestPath {
		int smallestLength = Integer.MAX_VALUE;
		int currentLength = 1;
		String currentPath = "";
		String shortestPath = "";
	}

	public static int BFS(int[][] grid, int[][] visited, ShortestPath sp) {

		if (grid.length == 0 || grid[0][0] == 1)
			return -1;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0, "(0,0)"));
		int numberOfSteps = 0;
		while (!queue.isEmpty()) {
			numberOfSteps++;
			int queueSize = queue.size();
			while (queueSize > 0) {
				Node n = queue.poll();
				visited[n.row][n.col] = 1;
				if (n.row == grid.length - 1 && n.col == grid[0].length - 1) {
					sp.shortestPath = n.path;
					return numberOfSteps;
				} else {
					for (int neighbour = 0; neighbour < 8; neighbour++) {
						int r = n.row + rows[neighbour];
						int c = n.col + cols[neighbour];
						if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 0
								&& visited[r][c] == 0) {
							queue.offer(new Node(r, c, n.path + "--(" + r + "," + c + ")"));
						}
					}
				}
				queueSize--;
			}
		}
		return -1;
	}

	static class Node {
		int row;
		int col;
		String path = "";

		Node(int row, int col, String path) {
			this.col = col;
			this.row = row;
			this.path = path;
		}
	}

}
