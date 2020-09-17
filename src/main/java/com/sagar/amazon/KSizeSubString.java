package com.sagar.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/discuss/interview-question/370112
 * 
 * @author sitapsha
 *
 */
public class KSizeSubString {

	public static void main(String[] args) {
		KSizeSubString ks = new KSizeSubString();
		System.out.println(ks.getSubStrings("abcabc", 3));
		System.out.println(ks.getSubStrings("abacab", 3));
		System.out.println(ks.getSubStrings("awaglknagawunagwkwagl", 4));
	}

	/**
	 * 
	 * Time complexity : O(n) where n is length of String Space complexity : O(n *
	 * k) result set space, worst case all characters in string is unique
	 * 
	 */
	public Set<String> getSubStrings(String s, int k) {

		if (s == null || s.isEmpty() || k > s.length()) {
			return new HashSet<>();
		}
		Set<String> result = new HashSet<>();

		int i = 0, j = 0;

		Map<Character, Integer> window = new HashMap<>();

		while (j < k) {
			window.put(s.charAt(j), window.getOrDefault(s.charAt(j), 0) + 1);
			j++;
		}
		if (window.size() == k) {
			result.add(s.substring(i, j));
		}
		while (j < s.length()) {

			// remove i th element to window
			if (window.get(s.charAt(i)) > 1) {
				window.put(s.charAt(i), window.get(s.charAt(i)) - 1);
			} else {
				window.remove(s.charAt(i));
			}

			// add j th element to window
			if (!window.containsKey(s.charAt(j))) {
				window.put(s.charAt(j), 1);
			} else {
				window.put(s.charAt(j), window.get(s.charAt(j)) + 1);
			}

			if (window.size() == k) {
				result.add(s.substring(i + 1, j + 1));
			}

			i++;
			j++;
		}
		return result;
	}

}
