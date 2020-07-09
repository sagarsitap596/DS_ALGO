package com.sagar.leetcode.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorImageBT {

	public static void main(String[] args) {
		Node r1 = createBT();
		Node r2 = createBT2();
//		System.out.println(isMirrioImage(r1, r2));
//		System.out.println(areMirrioImage(r1, r2));

		createMirrorImage(r1);
		createMirrorImage(r2);
		System.out.println(areMirrioImage(r1, r2));
	}

	private static Node createBT() {
		Node n4 = new Node(4, null, null);
		Node n5 = new Node(5, null, null);
		Node n6 = new Node(6, null, null);
		Node n7 = new Node(7, null, null);

		Node n2 = new Node(2, n4, n5);
		Node n3 = new Node(3, n6, n7);
		Node n1 = new Node(1, n2, n3);
		return n1;
	}

	private static Node createBT2() {
		Node n4 = new Node(4, null, null);
		Node n5 = new Node(5, null, null);
		Node n6 = new Node(6, null, null);
		Node n7 = new Node(7, null, null);

		Node n2 = new Node(2, n5, n4);
		Node n3 = new Node(3, n7, n6);
		Node n1 = new Node(1, n3, n2);
		return n1;
	}

	/*
	 * Using BFS strategy
	 * 
	 * Time complexity is O(N). Space complexity is O(N) due to Queue is used for
	 * storing nodes to be traversed next.
	 */
	public static boolean isMirrioImage(Node root1, Node root2) {

		// root 1 from left to right
		// root 2 from right to left

		Queue<Node> queue1 = new LinkedList<Node>();
		Queue<Node> queue2 = new LinkedList<Node>();

		queue1.offer(root1);
		queue2.offer(root2);

		boolean isMirrorImage = true;

		while (!queue1.isEmpty() && !queue2.isEmpty()) {
			Node node1 = queue1.poll();
			Node node2 = queue2.poll();
			if (!node1.value.equals(node2.value)) {
				isMirrorImage = false;
				break;
			}
			if (node1.left != null)
				queue1.offer(node1.left);
			if (node1.right != null)
				queue1.offer(node1.right);
			if (node2.right != null)
				queue2.offer(node2.right);
			if (node2.left != null)
				queue2.offer(node2.left);
		}
		return isMirrorImage;
	}

	/**
	 * Recursive
	 * 
	 * Time complexity is O(N) since every node is traversed once.<br>
	 * Space complexity is O(n) Because of recursion, O(h) function calls will be placed on the stack
	 * in the worst case, where h is the height of the tree. Because h ∈ O(n)
	 * (right/left skewed), the space complexity is O(n).
	 */
	public static boolean areMirrioImage(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return true;
		}
		if (node1 == null || node2 == null) {
			return false;
		}
		return node1.value.equals(node2.value) && areMirrioImage(node1.left, node2.right)
				&& areMirrioImage(node1.right, node2.left);
	}

	public static void createMirrorImage(Node node) {

		if (node == null) {
			return;
		}

		createMirrorImage(node.left);
		createMirrorImage(node.right);
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}

	static class Node {
		Node left;
		Node right;
		Integer value;

		public Node(Integer val, Node left, Node right) {
			this.value = val;
			this.left = left;
			this.right = right;
		}
	}
}
