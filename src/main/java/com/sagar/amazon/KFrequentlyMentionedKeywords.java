package com.sagar.amazon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class KFrequentlyMentionedKeywords {

	public static void main(String[] args) {

		List<String> comments = Arrays.asList("I love anacell Best services; Best services provided by anacell",
				"betacellular has great services", "deltacellular provides much better services than betacellular",
				"cetracular is worse than anacell", "Betacellular is better than deltacellular.");

		List<String> keyWords = Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");

		System.out.println(getKFrequentlyMentionedKeywords(comments, keyWords, 2));
	}

	// Total time complexity : O(C + k + klog k) = O(C + k)
	// Space complexity : O(k + n) n is max number of words in any comment
	public static List<String> getKFrequentlyMentionedKeywords(List<String> comments, List<String> keyWords, int k) {

		// Time O(k)
		// O(k)
		Set<String> allowedWords = keyWords.stream().map(s -> s.toLowerCase()).collect(Collectors.toSet());

		// space O(k)
		Map<String, Integer> count = new HashMap<>();

		// O(C) where C is total number of words in all comments
		for (String comment : comments) {
			String[] ws = comment.toLowerCase().split("\\s+");
			Set<String> visited = new HashSet<String>();
			for (String w : ws) {
				if (allowedWords.contains(w) && !visited.contains(w)) {
					count.put(w, count.getOrDefault(w, 0) + 1);
					visited.add(w);
				}
			}
		}

		// O(klogk)
		Collections.sort(keyWords, new CustomComparator(count));
		return keyWords.subList(0, k);

	}

	static class CustomComparator implements Comparator<String> {

		Map<String, Integer> count;

		CustomComparator(Map<String, Integer> count) {
			this.count = count;
		}

		@Override
		public int compare(String o1, String o2) {
			Integer count1 = 0;
			Integer count2 = 0;
			if (count.get(o1) != null) {
				count1 = count.get(o1);
			}
			if (count.get(o2) != null) {
				count2 = count.get(o2);
			}

			if (count1 == count2) {
				return o1.compareTo(o2);
			}
			return count2.compareTo(count1);
		}

	}

}
