package com.sagar.leetcode.binarytree;

import com.sagar.leetcode.binarytree.MirrorImageBT.Node;

public class FattenBT {

	public static void main(String[] args) {
		Node r1 = createBT();
		r1 = flattenBinaryTree(r1);
	}

	public static Node flattenBinaryTree(Node root) {

		FattenResult flattenResult = new FattenResult();
		flatten(root, flattenResult);
		flattenResult.root.left = null;
		flattenResult.node.right = null;
		return flattenResult.root;
	}

	private static void flatten(Node node, FattenResult flattenResult) {
		if (node == null) {
			return;
		}
		flatten(node.left, flattenResult);
		if (flattenResult.root == null) {
			flattenResult.root = node;
			flattenResult.node = node;
		} else {
			flattenResult.node.right = node;
			node.left = flattenResult.node;
			flattenResult.node = node;
		}
		flatten(node.right, flattenResult);
	}

	static class FattenResult {
		Node root;
		Node node;
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

}
