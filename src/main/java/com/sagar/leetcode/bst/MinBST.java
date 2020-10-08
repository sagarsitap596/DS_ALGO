package com.sagar.leetcode.bst;

import java.util.Arrays;
import java.util.List;

public class MinBST {

	public static void main(String[] args) {

		List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
		BST root = new BST(-1);
		insertInBst(0, array.size(), array, root);
	}

	private static void insertInBst(int start, int end, List<Integer> array, BST root) {
		if (start <= end) {
			int mid = (start + end) / 2;
			if (mid >= 0 && mid < array.size()) {
				if (root.value == -1) {
					root.value = array.get(mid);
				} else {
					root.insert(array.get(mid));
				}
				System.out.println(array.get(mid));
				insertInBst(start, mid - 1, array, root);
				insertInBst(mid + 1, end, array, root);
			}

		}
	}

	static class BST {
		public int value;
		public BST left;
		public BST right;

		public BST(int value) {
			this.value = value;
			left = null;
			right = null;
		}

		public void insert(int value) {
			if (value < this.value) {
				if (left == null) {
					left = new BST(value);
				} else {
					left.insert(value);
				}
			} else {
				if (right == null) {
					right = new BST(value);
				} else {
					right.insert(value);
				}
			}
		}
	}

}
