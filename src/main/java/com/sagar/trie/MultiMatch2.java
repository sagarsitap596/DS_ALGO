package com.sagar.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMatch2 {

	public static void main(String[] args) {
		System.out.println(multiStringSearch("this is this string", new String[] { "this string", "is this" }));

	}

	public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {

		List<Boolean> result = new ArrayList<>();
		Trie root = buildTrie(smallStrings);
		Set<String> containedString = new HashSet<>();

		for (int i = 0; i < bigString.length(); i++) {
			findSmallStringIn(i, bigString, root, containedString);
		}

		for (String smallString : smallStrings) {
			result.add(containedString.contains(smallString));
		}
		return result;
	}

	private static void findSmallStringIn(int startIndex, String bigString, Trie node, Set<String> containedStrings) {
		for (int i = startIndex; i < bigString.length(); i++) {
			char ch = bigString.charAt(i);
			if (node.childrens.containsKey(ch)) {
				node = node.childrens.get(ch);
				if (node.text != null) {
					containedStrings.add(node.text);
				}
			} else {
				break;
			}
		}
	}

	private static Trie buildTrie(String[] smallStrings) {
		Trie root = new Trie();
		for (String smallString : smallStrings) {
			addToTrie(root, smallString);
		}
		return root;
	}

	private static void addToTrie(Trie node, String smallString) {
		for (int i = 0; i < smallString.length(); i++) {
			char ch = smallString.charAt(i);
			if (!node.childrens.containsKey(ch)) {
				node.childrens.put(ch, new Trie());
			}
			node = node.childrens.get(ch);
		}
		node.text = smallString;
	}

	static class Trie {
		Map<Character, Trie> childrens = new HashMap<>();
		String text;
	}
}
