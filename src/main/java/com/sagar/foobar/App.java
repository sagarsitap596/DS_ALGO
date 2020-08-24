package com.sagar.foobar;

import java.util.HashMap;
import java.util.Map;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isValid("aadddeeee"));
//		System.out.println(isValid("abcc"));
//		System.out.println(isValid("aabdd"));
//		System.out.println(isValid("aaabbbb"));
//		System.out.println(isValid("aabbddcd"));

	}

	private static boolean isValid(String x) {
		Map<Character, Integer> count = new HashMap<>();
		for (char ch : x.toCharArray()) {
			count.put(ch, count.getOrDefault(ch, 0) + 1);
		}
		double noOfUnqueChars = count.size();
		double idealPerletterCount = Math.round(x.length() / noOfUnqueChars);
		int modified = 0;
		for (Character ch : count.keySet()) {
			if (count.get(ch) != idealPerletterCount) {
				if (Math.abs(count.get(ch) - idealPerletterCount) > 1) {
					return false;
				}
				modified++;
			}
		}
		return modified <= 1;
	}

}
