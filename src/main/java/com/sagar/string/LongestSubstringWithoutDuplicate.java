package com.sagar.string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutDuplicate {

	public static void main(String[] args) {
		System.out.println(longestSubstringWithoutDuplication("abcdeabcdefc"));

	}
	
	/**
	 * Time complexity : O(n)
	 * Space complexity : O(n)
	 * 
	 */
	public static String longestSubstringWithoutDuplication(String str) {
		Map<Character, Integer> lastIndex = new HashMap<>();
		int i = 0;
		int startIndex = 0;
		int maxStartIndex = 0;
		int maxEndIndex = 0;
		for (; i < str.length(); i++) {
			if (lastIndex.containsKey(str.charAt(i)) && lastIndex.get(str.charAt(i)) >= startIndex) {
				if ((maxEndIndex - maxStartIndex) < ((i - 1) - startIndex)) {
					maxStartIndex = startIndex;
					maxEndIndex = i - 1;
				}
				startIndex = lastIndex.get(str.charAt(i)) + 1;
			}
			lastIndex.put(str.charAt(i), i);
		}
		return str.substring(maxStartIndex, maxEndIndex + 1);
	}

}
