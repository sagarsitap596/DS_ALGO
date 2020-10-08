package com.sagar.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Time complexity : O(ws + bs)
 * Space complexity : O(ws + w)
 * 
 * @author sitapsha
 *
 */
public class MultiMatch {

	public static void main(String[] args) {
		System.out.println(multiStringSearch("this is a big string",
				new String[] { "this", "yo", "is", "a", "bigger", "string", "kappa" }));

	}

	public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
		TrieData root = createTrie(bigString);
		List<Boolean> result = new ArrayList<>();
		for (String s : smallStrings) {
			result.add(contains(s, root));
		}
		return result;
	}

	private static boolean contains(String s, TrieData root) {
		TrieData node = root;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (node.childrens.containsKey(ch)) {
				node = node.childrens.get(ch);
			} else {
				return false;
			}
		}
		return true;
	}

	private static TrieData createTrie(String s) {
		TrieData node = new TrieData();
		for (int i = 0; i < s.length(); i++) {
			addStringToTrie(s, i, node);
		}
		return node;
	}

	private static void addStringToTrie(String s, int startIndex, TrieData root) {
		TrieData node = root;
		for (int i = startIndex; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (!node.childrens.containsKey(ch)) {
				node.childrens.put(ch, new TrieData());
			}
			node = node.childrens.get(ch);
		}
		node.childrens.put('*', null);
	}

	static class TrieData {
		Map<Character, TrieData> childrens = new HashMap<>();
	}

}
