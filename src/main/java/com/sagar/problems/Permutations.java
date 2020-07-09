package com.sagar.problems;

import java.util.stream.Stream;

public class Permutations {

	public static void main(String[] args) {

		String text = "abc";

		permute(text.split(""), 0);

	}

	public static void permute(String[] array, int indexToBeFixed) {

		if (indexToBeFixed == array.length - 1) {
			Stream.of(array).forEach(s -> System.out.print(s));
			System.out.println();
		}
		for (int i = indexToBeFixed; i < array.length; i++) {
			swap(array, indexToBeFixed, i);
			permute(array, indexToBeFixed + 1);
			swap(array, indexToBeFixed, i);
		}

	}

	private static void swap(String[] array, int index, int i) {
		String temp = array[index];
		array[index] = array[i];
		array[i] = temp;
	}

}
