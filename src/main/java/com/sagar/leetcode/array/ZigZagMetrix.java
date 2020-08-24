package com.sagar.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagMetrix {

	public static void main(String[] args) {
		List<Integer> row1 = Arrays.asList(1, 3, 4, 10);
		List<Integer> row2 = Arrays.asList(2, 5, 9, 11);
		List<Integer> row3 = Arrays.asList(6, 8, 12, 15);
		List<Integer> row4 = Arrays.asList(7, 13, 14, 16);
		List<List<Integer>> mat = Arrays.asList(row1, row2, row3, row4);

//		List<Integer> row1 = Arrays.asList(1, 2, 3, 4, 5);
//		List<List<Integer>> mat = Arrays.asList(row1, );
		List<Integer> r = zigzagTraverse2(mat);
		System.out.println(r);

	}

	public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

		List<Integer> result = new ArrayList<>();
		if (array.size() == 1 && array.get(0).size() == 1) {
			result.add(array.get(0).get(0));
			return result;
		}

		// result.add(array.get(0).get(0));
		int i = 0;
		int j = 0;
		int noOfRows = array.size();
		int noOfCols = array.get(0).size();

		boolean goDown = true;
		while (!(i == noOfRows - 1 && j == noOfCols - 1)) {
			result.add(array.get(i).get(j));
			int ii = i;
			int jj = j;
			if (i == 0 && j < noOfCols - 1 && !goDown) { // first row
				ii = i;
				jj = j + 1;
				goDown = true;
			} else if (j == 0 && i < noOfRows - 1 && goDown) { // first column
				ii = i + 1;
				jj = j;
				goDown = false;
			} else if (i == noOfRows - 1 && goDown) { // last row
				ii = i;
				jj = j + 1;
				goDown = false;
			} else if (j == noOfCols - 1 && !goDown) { // last column
				ii = i + 1;
				jj = j;
				goDown = true;
			}

			if (ii == i && jj == j) {
				if (goDown) {
					i = i + 1;
					j = j - 1;
				} else {
					i = i - 1;
					j = j + 1;
				}
			} else {
				i = ii;
				j = jj;
			}
		}
		result.add(array.get(noOfRows - 1).get(noOfCols - 1));
		return result;
	}

	public static List<Integer> zigzagTraverse2(List<List<Integer>> array) {

		List<Integer> result = new ArrayList<>();
		if (array.size() == 1 && array.get(0).size() == 1) {
			result.add(array.get(0).get(0));
			return result;
		}

		// result.add(array.get(0).get(0));
		int row = 0;
		int col = 0;
		int noOfRows = array.size();
		int noOfCols = array.get(0).size();

		boolean isGoingDown = true;
		while (!(row == noOfRows - 1 && col == noOfCols - 1)) {
			result.add(array.get(row).get(col));

			if (isGoingDown) {
				if (row == noOfRows - 1) { // last row
					isGoingDown = false;
					col++;
				} else if (col == 0) { // first column
					isGoingDown = false;
					row++;
				} else { // on descending line ( / )
					row++;
					col--;
				}
			} else {
				if (col == noOfCols - 1) {
					isGoingDown = true;
					row++;
				} else if (row == 0) {
					isGoingDown = true;
					col++;
				} else {
					col++;
					row--;
				}
			}
		}
		result.add(array.get(noOfRows - 1).get(noOfCols - 1));
		return result;
	}

}
