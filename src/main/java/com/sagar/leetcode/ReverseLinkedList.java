package com.sagar.leetcode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// a -> b -> c
		// o/p = c -> b -> a
		Node n3 = new Node();
		n3.data = "c";
		n3.next = null;

		Node n2 = new Node();
		n2.data = "b";
		n2.next = n3;

		Node n1 = new Node();
		n1.data = "a";
		n1.next = n2;
		print(n1);
		reverseRecursively(n1);
		print(n3);
	}

	private static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	private static void reverseIterative(Node head) {

		Node prev = null;
		Node curr = head;
		Node next = null;

		// prev --> curr --> next

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
	}

	private static Node reverseRecursively(Node head) {
		if (head.next == null) {
			return head;
		}
		Node n = reverseRecursively(head.next);
		n.next = head;
		head.next = null;
		return head;
	}

	static class Node {
		Node next;
		String data;
	}
}
