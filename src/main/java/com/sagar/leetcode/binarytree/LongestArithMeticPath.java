package com.sagar.leetcode.binarytree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestArithMeticPath {

	public static void main(String[] args) {

		Node one = new Node(1, 1);
		Node two = new Node(3, 2);
		Node three = new Node(10, 3);
		Node four = new Node(40, 4);
		Node five = new Node(5, 5);
		Node six = new Node(17, 6);

		Map<Node, List<Node>> tree = new HashMap<>();
		tree.put(one, Arrays.asList(two, three, four));
		tree.put(two, Arrays.asList(one));
		tree.put(three, Arrays.asList(one, five, six));
		tree.put(four, Arrays.asList(one));
		tree.put(five, Arrays.asList(three));
		tree.put(six, Arrays.asList(three));

		System.out.println(findMaxPath(tree) - 1);
	}

	static class Node {
		int value;
		int number;
		List<Node> adjNodes = new ArrayList<>();

		Node(int value, int number) {
			this.value = value;
			this.number = number;
		}

		public void addNode(Node node) {
			this.adjNodes.add(node);
		}
	}

	public static int findMaxPath(Map<Node, List<Node>> tree) {

		int maxPath = Integer.MIN_VALUE;
		for (Node node : tree.keySet()) {
			int m = findMaxPath(node, null, tree, 1);
			if (m > maxPath) {
				maxPath = m;
			}
		}
		return maxPath;
	}

	private static int findMaxPath(Node startNode, Node prev, Map<Node, List<Node>> tree, int runningLength) {

		List<Node> adjNodes = tree.get(startNode);
		int maxLength = runningLength;
		for (Node adjNode : adjNodes) {
			if (adjNode != prev) {
				if (prev == null || runningLength == 1
						|| prev.value - startNode.value == startNode.value - adjNode.value) {

					int m = findMaxPath(adjNode, startNode, tree, runningLength + 1);
					if (m > maxLength) {
						maxLength = m;
					}
				}
			}
			maxLength = Math.max(maxLength, runningLength);
		}
		return maxLength;
	}

}
