package com.sagar.leetcode.array;

public class Solution3 {

	public static void main(String[] args) {
		Character[] row1 = new Character[2];

		System.out.println(new Solution3().solution(1, 0, new int[] { }));
	}

	public String solution(int U, int L, int[] C) {

		char[] row1 = new char[C.length];
		char[] row2 = new char[C.length];

		for (int i = 0; i < C.length; i++) {
			if (C[i] == 0) {
				row1[i] = '0';
				row2[i] = '0';
			} else if (C[i] == 2) {
				row1[i] = '1';
				row2[i] = '1';
				U--;
				L--;
			}
		}

		for (int i = 0; i < row1.length; i++) {
			if (row1[i] == '\u0000') {
				if (U != 0) {
					row1[i] = '1';
					row2[i] = '0';
					U--;
				} else if (L != 0) {
					row1[i] = '0';
					row2[i] = '1';
					L--;
				} else {
					row1[i] = '0';
					row2[i] = '0';
				}
			}
		}

		if (U != 0 || L != 0)
			return "IMPOSSIBLE";

		return new String(row1) + "," + new String(row2);
	}

}
