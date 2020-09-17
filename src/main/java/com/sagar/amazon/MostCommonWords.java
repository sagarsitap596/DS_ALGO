package com.sagar.amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * 
 * https://leetcode.com/problems/most-common-word/
 *
 * Total Time complexity : O(3p + b) = O(p + b)
 * Total space complexity : O(3p + b) = O(p + b)

*/

public class MostCommonWords {
	public String mostCommonWord(String paragraph, String[] banned) {

		// Time O(p) where p is length of paragraph
		// Space O(p)
		char[] paragraphChars = paragraph.toCharArray();
		for (int i = 0; i < paragraphChars.length; i++) {
			if (paragraphChars[i] == '!' || paragraphChars[i] == '?' || paragraphChars[i] == '\''
					|| paragraphChars[i] == ',' || paragraphChars[i] == ';' || paragraphChars[i] == '.') {
				paragraphChars[i] = ' ';
			} else {
				paragraphChars[i] = Character.toLowerCase(paragraphChars[i]);
			}
		}

		// Time O(b) where b is number of banned words
		// Space O(b)
		Set<String> bannedWords = createBannedSet(banned);

		// Time O(p) where p is length of paragraph
		// Space O(p)
		String[] words = new String(paragraphChars).split("\\s+");

		String maxWord = "";
		int maxCount = Integer.MIN_VALUE;

		// Time O(p) where p is length of paragraph
		// Space O(p)
		Map<String, Integer> count = new HashMap<>();
		for (String word : words) {
			if (!bannedWords.contains(word)) {
				count.put(word, count.getOrDefault(word, 0) + 1);
				if (maxCount < count.get(word)) {
					maxCount = count.get(word);
					maxWord = word;
				}
			}
		}
		return maxWord;
	}

//Time O(b) where b is number of banned words
//Space O(b)
	public Set<String> createBannedSet(String[] banned) {
		Set<String> bannedWords = new HashSet<>();
		for (String word : banned) {
			bannedWords.add(word);
		}
		return bannedWords;
	}
}
