package com.sagar.datastructures;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		java.util.LinkedList<String> stack2 = new java.util.LinkedList<>();

		// Add elements to Stack
		stack.push("1");
		stack.push("2");
		stack.push("3");

		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println("=====================");

		// Add elements to Stack
		stack2.push("1");
		stack2.push("2");
		stack2.push("3");

		System.out.println(stack2.pop());
		System.out.println(stack2.pop());
		System.out.println(stack2.pop());
		System.out.println("=====================");

	}

}
