package com.sagar.amazon;

import java.util.Arrays;

/**
 * 
 * 
 * https://leetcode.com/discuss/interview-question/762546/
 * 
 * @author sitapsha
 *
 */
public class FreshPromotion {

	public static void main(String[] args) {
		String[][] codeList = { { "apple", "apple" }, { "banana", "anything", "banana" } };

		System.out
				.println(isWinner(codeList, new String[] { "orange", "apple", "apple", "banana", "orange", "banana" }));

		System.out.println(isWinner(codeList, new String[] { "banana", "orange", "banana", "apple", "apple" }));

		System.out
				.println(isWinner(codeList, new String[] { "apple", "banana", "apple", "banana", "orange", "banana" }));

		System.out.println(isWinner(codeList, new String[] { "apple", "apple", "apple", "banana" }));

	}

	/*
	 * Total Time complexity : O(g * (n + c)) = (N + C) where N is total number of
	 * items in codeList Space complexity : O(c)
	 */
	public static int isWinner(String[][] codeList, String[] shopingCart) {

		if (shopingCart.length == 0) {
			return 0;
		}

		int cartStartIndex = 0;
		int codeIndex = 0;

		// Time complexity : O(g) where g is number of groups
		while (codeIndex < codeList.length && cartStartIndex < shopingCart.length) {
			cartStartIndex = contains(codeList[codeIndex], shopingCart, cartStartIndex);
			if (cartStartIndex == -1) {
				return 0;
			}
			codeIndex++;
		}

		if (codeIndex < codeList.length && cartStartIndex >= shopingCart.length) {
			return 0;
		}
		return 1;
	}

	// Time complexity : O(n + c) where n is number of items in group and c is
	// number of items in cart
	// Space complexity : O(c) creating indexes at any given point of time.
	private static int contains(String[] code, String[] cart, int cartStartIndex) {

		int[] indexes = new int[code.length];
		Arrays.fill(indexes, -1);
		int j = 0;
		int i = 1;
		while (i < code.length) {
			if ("anything".equals(code[j]) || code[j].equals(code[i])) {
				indexes[i] = j;
				i++;
				j++;
			} else if (j > 0) {
				j = indexes[j - 1] + 1;
			} else {
				i++;
			}
		}

		j = 0;
		i = cartStartIndex;
		while (i < cart.length && j < code.length) {
			if ("anything".equals(code[j]) || code[j].equals(cart[i])) {
				i++;
				j++;
			} else if (j > 0) {
				j = indexes[j - 1] + 1;
			} else {
				i++;
			}
		}
		if (j == code.length) {
			return i;
		}

		return -1;
	}

}
