package com.sagar.string;

import java.util.ArrayList;
import java.util.List;

public class Underscorify {

	public static void main(String[] args) {

		System.out.println(underscorifySubstring("abababababababababababababaababaaabbababaa", "a"));

	}

	public static String underscorifySubstring(String str, String substring) {

		System.out.println(str.length());
		List<Integer> indexes = buildIndexes(str, substring);

		System.out.println(indexes);
		char[] result = new char[str.length() + indexes.size()];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < str.length() || k < result.length) {
			if (j < indexes.size() && i == indexes.get(j)) {
				result[k] = '_';
				j++;
			} else {
				result[k] = str.charAt(i);
				i++;
			}
			k++;
		}
//		if (k < result.length) {
//			result[k] = '_';
//		}

		return new String(result);
	}

	private static List<Integer> buildIndexes(String str, String substring) {
		List<Integer> indexes = new ArrayList<>();
		int i = 0;
		while(i < str.length()) {
			int startIndex = str.substring(i).indexOf(substring);
			if (startIndex == -1) {
				break;
			} else {
				startIndex = startIndex + i;
				if (!indexes.isEmpty() && indexes.get(indexes.size() - 1) >= startIndex) {
					indexes.set(indexes.size() - 1, startIndex + substring.length()); // extend endIndex if overlap
				} else {
					indexes.add(startIndex);
					indexes.add(startIndex + substring.length());
				}
			}
			i = startIndex + 1;
		}
		return indexes;
	}
}
