package com.sagar.leetcode.linkedlist;

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
		Node head = n1;
		print(head);
		head = reverseRecursively(head);
		// head = reverseIterative(head);
		print(head);
	}

	private static void print(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	private static Node reverseIterative(Node head) {

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
		return prev;
	}

	private static Node reverseRecursively(Node head) {
		if (head.next == null) {
			return head;
		}
		Node n = reverseRecursively(head.next);
		/*
		 * for a -> b -> c -> d -> null
		 * 
		 * last recursive (head = d) call return d last recursive (head = c) call : a ->
		 * b -> c -> null d -> c and return d second last recursive (head = b) call : a
		 * -> b -> null d -> c -> b and return d third last recursive (head = a) call :
		 * a -> null d -> c -> b -> a and retun d
		 * 
		 * 
		 */

		head.next.next = head;
		head.next = null;
		return n;
	}

	static class Node {
		Node next;
		String data;
	}
}
