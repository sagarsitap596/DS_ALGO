package com.sagar.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class LargestAssociation {

	public static void main(String[] args) {
		LargestAssociation la = new LargestAssociation();

		System.out.println(la.largestItemAssociation(la.createPairs()));

	}

	private List<PairString> createPairs() {
		List<PairString> l = new ArrayList<LargestAssociation.PairString>();

		l.add(new PairString("j", "k"));
		l.add(new PairString("k", "l"));
		l.add(new PairString("l", "m"));
		l.add(new PairString("m", "n"));
		l.add(new PairString("g", "h"));
		l.add(new PairString("e", "f"));
		l.add(new PairString("b", "c"));
		l.add(new PairString("d", "e"));
		l.add(new PairString("f", "g"));
		l.add(new PairString("a", "b"));

		return l;
	}

	public List<String> largestItemAssociation(List<PairString> itemAssociation) {

		Map<String, String> associations = createAssociations(itemAssociation);
		Map<String, List<String>> visited = new HashMap<>();
		PriorityQueue<List<String>> max = new PriorityQueue<>((l1, l2) -> l2.get(0).compareTo(l1.get(0)));

		// Time complexity : o(v + e) + vlog v where v is number of pairs and e is
		// number linked associations
		// Space complexity : O(n)
		for (Map.Entry<String, String> entry : associations.entrySet()) {
			String start = entry.getKey();
			if (!visited.containsKey(start)) {
				List<String> ls = traverseAssociations(start, associations, visited);
				if (max.isEmpty() || max.peek().size() == ls.size()) {
					Collections.sort(ls);
					max.add(ls);
				} else if (max.peek().size() < ls.size()) {
					max.clear();
					Collections.sort(ls);
					max.add(ls);
				}

			}
		}
		System.out.println(max);
		return max.peek();
	}

	// Time O(n)
	// Space O(n)
	private List<String> traverseAssociations(String start, Map<String, String> associations,
			Map<String, List<String>> visited) {

		if (start == null) {
			return new ArrayList<>();
		}
		if (visited.containsKey(start)) {
			return visited.get(start);
		} else {
			List<String> p = new ArrayList<>();
			p.add(start);
			p.addAll(traverseAssociations(associations.get(start), associations, visited));
			visited.put(start, p);
			return p;
		}
	}

	// Time O(n)
	// Space O(n)
	private Map<String, String> createAssociations(List<PairString> itemAssociation) {
		Map<String, String> mapping = new HashMap<String, String>();
		for (PairString pairString : itemAssociation) {
			mapping.put(pairString.first, pairString.second);
		}
		return mapping;
	}

	public class PairString {
		String first;
		String second;

		public PairString(String first, String second) {
			this.first = first;
			this.second = second;
		}
	}
}
