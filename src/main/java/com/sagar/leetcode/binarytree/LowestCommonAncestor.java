package com.sagar.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
 * 
 * @author sitapsha
 *
 */
public class LowestCommonAncestor {

	private TreeNode createBST(Integer[] array) {

		TreeNode root = new TreeNode(array[0]);
		for (Integer n : array) {
			if (n == null)
				continue;
			root.insert(n);
		}
		return root;
	}

	public static void main(String[] args) {
		LowestCommonAncestor lca = new LowestCommonAncestor();
		TreeNode root = lca.createBST(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(4);
		System.out.println(lca.lowestCommonAncestor(root, p, q).val);
		System.out.println(lca.getLCA(root, p, q).val);
		System.out.println(lca.lowestCommonAncestorEfficient(root, p, q).val);
		System.out.println(lca.lowestCommonAncestorEfficientRecurssion(root, p, q).val);
	}

	/*
	 * Time : O(n) if bst is skewed left or right. if bst is balanced than it log n
	 * Space : O(1)
	 */
	public TreeNode lowestCommonAncestorEfficient(TreeNode root, TreeNode p, TreeNode q) {

		while (root != null) {
			if (p.val < root.val && q.val < root.val) {
				root = root.left;
			} else if (p.val > root.val && q.val > root.val) {
				root = root.right;
			} else {
				return root;
			}
		}
		return null;
	}

	/*
	 * Time : O(n) if bst is skewed left or right. if bst is balanced than it log n
	 * Space : O(1)
	 */
	public TreeNode lowestCommonAncestorEfficientRecurssion(TreeNode root, TreeNode p, TreeNode q) {

		if (root == null) {
			return null;
		}
		if (p.val < root.val && q.val < root.val) {
			return lowestCommonAncestorEfficientRecurssion(root.left, p, q);
		} else if (p.val > root.val && q.val > root.val) {
			return lowestCommonAncestorEfficientRecurssion(root.right, p, q);
		} else {
			return root;
		}

	}

	/**
	 * Time complexity : O(n) Space complexity : O(h) h is height of tree on call
	 * stack
	 * 
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		LCA lca = new LCA(root);
		getLCM(root, p, q, lca);
		return lca.lca;
	}

	private int getLCM(TreeNode node, TreeNode p, TreeNode q, LCA lca) {
		if (node == null) {
			return 0;
		}
		int count = 0;
		if (node.val == p.val || node.val == q.val) {
			count = 1;
		}
		count = count + getLCM(node.left, p, q, lca);
		count = count + getLCM(node.right, p, q, lca);
		if (count == 2) {
			lca.lca = node;
			return -1;
		}
		return count;
	}

	static class LCA {
		TreeNode lca;

		LCA(TreeNode node) {
			this.lca = node;
		}
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			this.val = x;
		}

		public void insert(int val) {
			if (val <= this.val) {
				if (this.left == null) {
					this.left = new TreeNode(val);
				} else {
					this.left.insert(val);
				}
			} else {
				if (this.right == null) {
					this.right = new TreeNode(val);
				} else {
					this.right.insert(val);
				}
			}
		}
	}

	/////////////////////////////////

	/**
	 * Time complexity : O(log n) Space complexity : O(log n)
	 */
	private TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pParents = getParents(root, p); // log n
		List<TreeNode> qParents = getParents(root, q); // log n

		int i = 0;
		while (i < pParents.size() && i < qParents.size() && pParents.get(i).val == qParents.get(i).val) {
			i++;
		}
		return pParents.get(i - 1);
	}

	private List<TreeNode> getParents(TreeNode root, TreeNode node) {
		List<TreeNode> ps = new ArrayList<>();
		while (root.val != node.val) {
			ps.add(root);
			if (node.val <= root.val) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		ps.add(node);
		return ps;
	}

}
