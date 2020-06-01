package com.sagar.datastructures;

import com.j256.ormlite.stmt.query.In;

public class BinarySearchTree {
	public static void main(String[] args) {
		BTSNode root = new BTSNode(5);
		root.insert(2);
		root.insert(7);
		root.insert(4);
		root.insert(6);

		System.out.println("===================");
		root.printInOrder();// 2 4 5 6 7
		System.out.println("===================");
		root.printPostOrder();// 4 2 6 7 5
		System.out.println("===================");
		root.printPreOrder();// 5 2 4 7 6
		System.out.println("===================");
	}
}

class BTSNode {
	Integer data;
	BTSNode left;
	BTSNode right;

	public BTSNode(Integer data) {
		super();
		this.data = data;
	}

	/**
	 * O(log N)
	 * @param data
	 */
	public void insert(Integer data) {
		if (data <= this.data) {
			if (this.left == null) {
				left = new BTSNode(data);
			} else {
				left.insert(data);
			}
		} else {
			if (this.right == null) {
				right = new BTSNode(data);
			} else {
				right.insert(data);
			}
		}
	}

	/**
	 *  O(log N)
	 * @param data
	 * @return
	 */
	public boolean contains(Integer data) {
		if (data == this.data) {
			return true;
		} else if (data < this.data) {
			if (left == null) {
				return false;
			} else {
				return left.contains(data);
			}
		} else {
			if (right == null) {
				return false;
			} else {
				return right.contains(data);
			}
		}
	}

	/*
	 * Node to be deleted is leaf.<br>
	 * Node to be deleted has only one child.<br>
	 * Node to be deleted has two children.
	 * O(log N).
	 * If tree is not balanced (which is in a way linked list)then its O(N) 
	 */
	public BTSNode delete(Integer val, BTSNode root) {

		/*
		 * This will encounter if node is not found and we have traversed till end (leaf
		 * node's left/right)
		 */
		if (root == null)
			return root;

		if (val < root.data) {
			root.left = delete(val, root.left);
		} else if (val > root.data) {
			root.right = delete(val, root.right);
		} else {

			/*
			 * Node to be deleted is leaf Node to be deleted has only one child
			 */
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			}

			/**
			 * Node to be deleted has two children
			 */
			Integer max = max(root.left);
			root.data = max;
			root.left = delete(max, root.left);
		}
		return root;

	}

	private Integer max(BTSNode node) {
		if (node.right == null) {
			return node.data;
		} else {
			return max(right);
		}
	}

	/**
	 * 1. Go left if present
	 * 2. If left id null, print current node
	 * 3. go right and follow step 1
	 */
	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.print(data + " ");
		if (right != null) {
			right.printInOrder();
		}
	}

	public void printPreOrder() {
		System.out.print(data + " ");
		if (left != null) {
			left.printPreOrder();
		}
		if (right != null) {
			right.printPreOrder();
		}
	}

	public void printPostOrder() {
		if (left != null) {
			left.printPostOrder();
		}
		if (right != null) {
			right.printPostOrder();
		}
		System.out.print(data + " ");
	}

}
