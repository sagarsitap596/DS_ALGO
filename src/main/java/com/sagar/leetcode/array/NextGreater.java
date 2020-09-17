package com.sagar.leetcode.array;

import java.util.Stack;

public class NextGreater {

	public static void main(String[] args) {
//		int[] array = { 1, 3, 2, 4 };
		int[] array = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11 };

		int count = 0;

		int[] result = new int[array.length];

		Stack<Integer> stack = new Stack<>();
		stack.push(0);
		for (int i = 1; i < array.length; i++) {
			count++;
			while (!stack.isEmpty() && array[stack.peek()] < array[i]) {
				result[stack.pop()] = array[i];
				count++;
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			count++;
			result[stack.pop()] = -1;
		}

		for (int i = 0; i < array.length; i++) {
			System.out.print(result[i] + "  ");
		}
		System.out.println(count);
	}
}
