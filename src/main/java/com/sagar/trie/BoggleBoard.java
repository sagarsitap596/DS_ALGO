package com.sagar.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BoggleBoard {

	public static void main(String[] args) {
		char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
		String[] words = { "abcd", "abdc", "acbd", "acdb", "adbc", "adcb", "abca" };
		System.out.println(boggleBoard(board, words));
	}

	static int[] rowCounter = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] colCounter = { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static List<String> boggleBoard(char[][] board, String[] words) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		Tries tries = new Tries();
		for (String word : words) {
			tries.add(word);
		}
		Set<String> result = new HashSet<>();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[0].length; col++) {
				traverseInDFS(row, col, board, visited, result, tries.root);
			}
		}
		return new ArrayList<String>(result);
	}

	private static void traverseInDFS(int row, int col, char[][] board, boolean[][] visited, Set<String> result,
			TrieNode node) {
		if (row >= 0 && col >= 0 && row < board.length && col < board[0].length && !visited[row][col]) { // if not
																											// visited
			visited[row][col] = true;
			if (node.childeren.containsKey(board[row][col])) { // if current char in board is in current TrieNode level.
				for (int k = 0; k < 8; k++) {
					TrieNode nextNode = node.childeren.get(board[row][col]);
					traverseInDFS(row + rowCounter[k], col + colCounter[k], board, visited, result, nextNode);
					if (nextNode.childeren.containsKey('*')) {
						result.add(nextNode.word);
					}
				}
			}
			visited[row][col] = false;
		}
	}

	static class Tries {
		TrieNode root = new TrieNode();

		public void add(String str) {
			TrieNode node = root;
			for (char c : str.toCharArray()) {
				if (!node.childeren.containsKey(c)) {
					node.childeren.put(c, new TrieNode());
				}
				node = node.childeren.get(c);
			}
			node.childeren.put('*', null);
			node.word = str;
		}
	}

	static class TrieNode {
		Map<Character, TrieNode> childeren = new HashMap<>();
		String word;
	}

}
