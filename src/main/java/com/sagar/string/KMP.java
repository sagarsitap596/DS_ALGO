package com.sagar.string;

import java.util.Arrays;

public class KMP {

	public static void main(String[] args) {
		System.out.println(knuthMorrisPrattAlgorithm("aefaefaefaedaefaedaefaefa", "aefaedaefaefa"));

	}

	public static boolean knuthMorrisPrattAlgorithm(String string, String substring) {
		int[] patternIndex = createPatterIndex(substring);
		Arrays.stream(patternIndex).forEach(e -> System.out.print(e + " "));
		int i = 0;
		int j = 0;

		while (i < string.length() && j < substring.length()) {
			if (string.charAt(i) == substring.charAt(j)) {
				i++;
				j++;
			} else if (j > 0) {
				if (patternIndex[j - 1] == -1) {
					j = 0;
				} else {
					j = patternIndex[j - 1] + 1;
				}
			} else {
				i++;
			}
		}

		return j == substring.length();
	}

	private static int[] createPatterIndex(String str) {
		int[] patternIndex = new int[str.length()];
		Arrays.fill(patternIndex, -1);
		int i = 1, j = 0;

		while (i < str.length()) {
			if (str.charAt(j) == str.charAt(i)) {
				patternIndex[i] = j;
				i++;
				j++;

			} else if (j > 0) {
				if (patternIndex[j - 1] == -1) {
					j = 0;
				} else {
					j = patternIndex[j - 1] + 1;
				}
			} else {
				i++;
			}
		}
		return patternIndex;
	}

}
