package com.sagar.leetcode.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// a -> b -> c
		// o/p = c -> b -> a

		Node n7 = new Node();
		n7.data = "g";
		n7.next = null;

		Node n6 = new Node();
		n6.data = "f";
		n6.next = n7;

		Node n5 = new Node();
		n5.data = "e";
		n5.next = n6;

		Node n4 = new Node();
		n4.data = "d";
		n4.next = n5;

		Node n3 = new Node();
		n3.data = "c";
		n3.next = n4;

		Node n2 = new Node();
		n2.data = "b";
		n2.next = n3;

		Node n1 = new Node();
		n1.data = "a";
		n1.next = n2;
		Node head = n1;
		print(head);
		head = reverseKElementsAtATime(head, 3);
//		head = reverseRecursively(head);
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

	private static Node reverseKElementsAtATime(Node head, int k) {
		Node current = head;
		Node startNode = head;
		Node prev = null;
		Node newHead = head;
		int count = 1;
		while (count < k) {
			newHead = newHead.next;
			count++;
		}

		count = 1;
		while (current != null) {
			if (count == 1) {
				startNode = current;
			}
			if (count == k) {
				current = current.next;
				reverseLinkedList(startNode, prev, current, k);
				prev = startNode;
				count = 1;
				continue;
			}
			count++;
			current = current.next;
		}
		return newHead;

	}

	private static void reverseLinkedList(Node startNode, Node leftBound, Node rightBound, int k) {

		Node prev = null;
		Node current = startNode;
		Node next = null;

		while (k > 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			k--;
		}
		if (leftBound != null)
			leftBound.next = prev;

		startNode.next = rightBound;
	}

	static class Node {
		Node next;
		String data;
	}
}
