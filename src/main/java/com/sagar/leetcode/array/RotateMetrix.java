package com.sagar.leetcode.array;

public class RotateMetrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] mat = {
//				{1, 2, 3 },{4 ,5, 6 },{7 ,8 ,9}
//		};
		
		int[][] mat = {
				{1, 2, 3,4 },{5, 6,7,8 },{9,10,11,12},{13,14,15,16}
		};
		rotate(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println();
		}
		
 	}

	/**
	 * step 1: Transpose : row become columns and cols become rows. <br>
	 * step 2: reverse all rows
	 * 
	 * 1 2 3   transpose  1 4 7    reverse all rows  7 4 1
	 * 4 5 6     -->      2 5 8          -->         8 5 2
	 * 7 8 9              3 6 9                      9 6 3
	 * 
	 * 
	 * 1  2  3  4    transpose  1 5 9  13  reverse all rows  13 9 5  1
	 * 5  6  7  8               2 6 10 14                    14 10 6 2
	 * 9  10 11 12              3 7 11 15                    15 11 7 3
	 * 13 14 15 16              4 8 12 16                    16 12 8 4
	 * 
	 */
	public static void rotate(int[][] mat) {

		int m = mat.length;
		int n = mat[0].length;
		if(m!=n) {
			throw new RuntimeException("Not a square metrix");
		}
		// step 1: transpose

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + "  ");
			}
			System.out.println();
		}
		System.out.println("transpose");
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n/2; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[i][n-1-j];
				mat[i][n-1-j] = temp;
			}
		}
	}
}
