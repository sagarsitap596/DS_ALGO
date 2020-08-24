package com.sagar.datastructures;

public class BinarySearchTree {
	public static void main(String[] args) {
		BTSNode root = new BTSNode(5);
		root.insertIterative(2);
		root.insertIterative(7);
		root.insertIterative(4);
		root.insertIterative(6);

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
	 * 
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

	public void insertIterative(Integer data) {
		BTSNode curr = this;
		while (curr != null) {
			if (data <= curr.data) {
				if (curr.left == null) {
					curr.left = new BTSNode(data);
					break;
				}
				curr = curr.left;
			} else {
				if (curr.right == null) {
					curr.right = new BTSNode(data);
					break;
				}
				curr = curr.right;
			}
		}
	}

	/**
	 * O(log N)
	 * 
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
	 * Node to be deleted is leaf.<br> Node to be deleted has only one child.<br>
	 * Node to be deleted has two children. O(log N). If tree is not balanced (which
	 * is in a way linked list)then its O(N)
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

	public BTSNode remove(int data) {
		// Write your code here.
		if (this.data == data && this.left == null && this.right == null)
			return this;
		BTSNode prev = null;
		BTSNode current = this;
		while (current != null) {
			if (data < current.data) {
				prev = current;
				current = current.left;
			} else if (data > current.data) {
				prev = current;
				current = current.right;
			} else {
				break;
			}
		}
		if (current != null) {
			BTSNode node = null;
			if (current.right == null) {
				node = current.left;
			} else if (current.left == null) {
				node = current.right;
			} else {
				BTSNode smallestRight = removeSmallest(current.right);
				if (smallestRight.data != current.right.data) {
					smallestRight.right = current.right;
				}
				smallestRight.left = current.left;
				node = smallestRight;
			}
			if (prev == null) {
				this.data = node.data;
				this.left = node.left;
				this.right = node.right;
			} else if (current.data < prev.data) {
				prev.left = node;
			} else {
				prev.right = node;
			}
		}
		return this;
	}

	private static BTSNode removeSmallest(BTSNode node) {
		if (node.left == null)
			return node;

		BTSNode prev = null;
		while (node.left != null) {
			prev = node;
			node = node.left;
		}
		prev.left = null;
		return node;
	}

	private Integer max(BTSNode node) {
		if (node.right == null) {
			return node.data;
		} else {
			return max(right);
		}
	}

	/**
	 * 1. Go left if present 2. If left id null, print current node 3. go right and
	 * follow step 1
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
