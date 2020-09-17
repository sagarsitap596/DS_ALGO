package com.sagar.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class KmostFrequent {

	public static void main(String[] args) {
		String[] words = { "i", "love", "leetcode", "i", "love", "coding" };

		int k = 3;

		System.out.println(topKFrequent(words, k));
		System.out.println(topKFrequent2(words, k));
	}

	public static List<String> topKFrequent(String[] words, int k) {

		if (words.length == 0) {
			return new ArrayList<>();
		}
		Map<String, Integer> count = new HashMap<>();
		for (String word : words) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}

		Queue<Map.Entry<String, Integer>> q = new PriorityQueue<>(new CustomComparator());
		for (Map.Entry<String, Integer> entry : count.entrySet()) {
			q.add(entry);
		}
		List<String> result = new ArrayList<>();
		while (k > 0) {
			result.add(q.poll().getKey());
			k--;
		}
		return result;
	}

	public static List<String> topKFrequent2(String[] words, int k) {

		if (words.length == 0) {
			return new ArrayList<>();
		}
		Map<String, Integer> count = new HashMap<>();
		for (String word : words) {
			count.put(word, count.getOrDefault(word, 0) + 1);
		}

		List<String> wordList = new ArrayList<>(count.keySet());

		Collections.sort(wordList,
				(w1, w2) -> count.get(w1) == count.get(w2) ? w1.compareTo(w2) : count.get(w2).compareTo(count.get(w1)));

		return wordList.subList(0, k);
	}

	static class CustomComparator implements Comparator<Map.Entry<String, Integer>> {

		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			if (o1.getValue() == o2.getValue())
				return o1.getKey().compareTo(o2.getKey());
			return o2.getValue().compareTo(o1.getValue());

		}
	}
}
