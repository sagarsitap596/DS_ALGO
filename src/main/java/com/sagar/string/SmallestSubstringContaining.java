package com.sagar.string;

import java.util.HashMap;
import java.util.Map;

class SmallestSubstringContaining {

	public static void main(String[] args) {
		System.out.println(smallestSubstringContaining("145624356128828193236336541277356789901", "123"));
	}

	public static String smallestSubstringContaining(String bigString, String smallString) {

		if (smallString.length() > bigString.length())
			return "";

		int start = 0;
		int end = bigString.length() - 1;
		Map<Character, Integer> smallCount = countChacter(smallString);
		int uniqueCount = smallCount.size();
		Map<Character, Integer> window = new HashMap<>();

		int left = 0;
		int right = 0;

		while (right < bigString.length()) {
			char c = bigString.charAt(right);
			if (smallCount.containsKey(c)) {
				window.put(c, window.getOrDefault(c, 0) + 1);
				if (window.get(c) == smallCount.get(c)) {
					uniqueCount--;
					if (uniqueCount == 0) {
						if (right - left < end - start) {
							start = left;
							end = right;
						}
						left = updateLeftIndex(left, right, window, smallCount, bigString);
						uniqueCount = uniqueCount + 1;
						if (right - (left - 1) < (end - start)) {
							start = left - 1;
							end = right;
						}
					}
				}

			}

			right++;
		}
		return bigString.substring(start, end + 1);
	}

	private static int updateLeftIndex(int left, int right, Map<Character, Integer> window,
			Map<Character, Integer> smallCount, String bigString) {
		while (left < right) {
			char c = bigString.charAt(left);
			if (window.containsKey(c)) {
				window.put(c, window.get(c) - 1);
				if (window.get(c) < smallCount.get(c)) {
					return left + 1;
				}
			}
			left++;
		}
		return left + 1;
	}

	private static Map<Character, Integer> countChacter(String str) {
		Map<Character, Integer> count = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			count.put(c, count.getOrDefault(c, 0) + 1);
		}
		return count;
	}
}
