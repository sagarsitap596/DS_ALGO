package com.sagar.string;

import java.util.*;

import java.util.*;

class App {

	public static void main(String[] args) {
		String[] r = patternMatcher("yxx", "yomama");
		System.out.println(r[0]);
		System.out.println(r[1]);
	}

	public static String[] patternMatcher(String pattern, String str) {

		if (pattern.length() > str.length())
			return new String[] {};

		Map<Character, Integer> count = new HashMap<>();
		String pattern2 = invertPattern(pattern);
		boolean isPatternModified = pattern.charAt(0) != pattern2.charAt(0);
		int startIndexY = getYStartIndex(pattern2, count); // in pattern
		if (startIndexY >= 0) {
			for (int xLength = 1; xLength < str.length(); xLength++) {
				int totalYLength = (str.length() - (count.get('x') * xLength));
				if (totalYLength > 0 && totalYLength % count.get('y') == 0) {
					int yLength = (str.length() - (count.get('x') * xLength)) / count.get('y');
					int startIndexOfY = (startIndexY * xLength); // startIndexY in patter means these many x before y
					String y = str.substring(startIndexOfY, startIndexOfY + yLength);
					String x = str.substring(0, xLength);

					String newStr = buildNewString(x, y, pattern2);
					if (newStr.equals(str)) {
						if (isPatternModified) {
							return new String[] { y, x };
						}
						return new String[] { x, y };
					}
				}
			}
		} else {
			int xLength = str.length() / count.get('x');
			String x = str.substring(0, xLength);
			if (isPatternModified) {
				return new String[] { "", x };
			}
			return new String[] { x, "" };
		}
		return new String[] {};
	}

	private static String buildNewString(String x, String y, String pattern2) {
		StringBuilder sb = new StringBuilder();
		for (char ch : pattern2.toCharArray()) {
			if(ch =='x') {
				sb.append(x);
			}
			else {
				sb.append(y);
			}
		}
		return sb.toString();
	}

	private static String invertPattern(String pattern) {
		if (pattern.startsWith("x"))
			return pattern;

		char[] pattern2 = new char[pattern.length()];
		for (int i = 0; i < pattern.length(); i++) {
			pattern2[i] = pattern.charAt(i) == 'x' ? 'y' : 'x';
		}
		return new String(pattern2);
	}

	private static int getYStartIndex(String pattern, Map<Character, Integer> count) {
		int yIndex = -1;
		for (int i = 0; i < pattern.length(); i++) {
			if (yIndex == -1 && pattern.charAt(i) == 'y') {
				yIndex = i;
			}
			count.put(pattern.charAt(i), count.getOrDefault(pattern.charAt(i), 0) + 1);
		}
		return yIndex;
	}
}
