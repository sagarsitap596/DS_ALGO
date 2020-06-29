package com.sagar.leetcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class KthMostFrequentlyRecurringInteger {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 2, 3, 4, 3, 4, 5, 5, 5, 5, 5, 3, 3, 3, 3, 3, 3 };
		System.out.println(getKthMostFrequentlyRecurringInteger(array, 1));
	}

	private static int getKthMostFrequentlyRecurringInteger(int[] array, int k) {

		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i : array) {
			countMap.put(i, countMap.getOrDefault(i, 1) + 1);
		}

		List<Map.Entry<Integer, Integer>> ls = new ArrayList<>(countMap.entrySet());

		Collections.sort(ls, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

//		ls.stream().forEach(e -> System.out.println(e.getValue()));
		return ls.get(k - 1).getKey();
	}
	


}
