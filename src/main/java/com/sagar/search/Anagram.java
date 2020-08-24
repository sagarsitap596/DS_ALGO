package com.sagar.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {

	public static void main(String[] args) {

		System.out.println(isAnagram("ab", "a"));

	}

	public static List<List<String>> groupAnagrams(List<String> words) {
		Map<String, List<String>> anagrams = new HashMap<>();
		for (int i = 0; i < words.size(); i++) {
			String s = sortString(words.get(i));
			if (anagrams.containsKey(s)) {
				anagrams.get(s).add(words.get(i));
			} else {
				List<String> ls = new ArrayList<>();
				ls.add(words.get(i));
				anagrams.put(s, ls);
			}
		}
		return new ArrayList<List<String>>(anagrams.values());
	}

	private static String sortString(String str) {
		char[] charArray = str.toCharArray();
		Arrays.sort(charArray);
		return new String(charArray);
	}

	private static boolean isAnagram(String s1, String s2) {
		Map<Character, Integer> cache = new HashMap<>();
		for (char ch : s1.toCharArray()) {
			cache.put(ch, cache.getOrDefault(ch, 0) + 1);
		}
		for (char ch : s2.toCharArray()) {
			if (cache.containsKey(ch)) {
				if (cache.get(ch) == 1) {
					cache.remove(ch);
				} else {
					cache.put(ch, cache.get(ch) - 1);
				}
			} else {
				return false;
			}
		}
		return cache.isEmpty();
	}

}
