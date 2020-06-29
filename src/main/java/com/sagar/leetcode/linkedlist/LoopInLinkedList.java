package com.sagar.leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LoopInLinkedList {

	public static void main(String[] args) {
		LinkedList n0 = new LinkedList(0);
		LinkedList n1 = new LinkedList(1);
		LinkedList n2 = new LinkedList(2);
		LinkedList n3 = new LinkedList(3);
		LinkedList n4 = new LinkedList(4);
		LinkedList n5 = new LinkedList(5);
		LinkedList n6 = new LinkedList(6);
		LinkedList n7 = new LinkedList(7);
		LinkedList n8 = new LinkedList(8);
		LinkedList n9 = new LinkedList(9);

		LinkedList head = n0;
		n0.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n8.next = n6;

		System.out.println(findLoop(head).value);
		System.out.println(findLoop2(head).value);
	}

	// Time complexity = O(N)
	// Spcae complexity = O(1)
	public static LinkedList findLoop(LinkedList head) {
		LinkedList slow = head;
		LinkedList fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		// distance from head to start point of loop = distance from fast to start point
		// of loop -- maths.
		// so start slow from head again and brak when slow = fast. which is start point
		// of loop
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}

	// Time complexity = O(N)
	// Spcae complexity = O(N) -- used Hashset
	public static LinkedList findLoop2(LinkedList head) {
		Set<LinkedList> visited = new HashSet<>();

		LinkedList node = head;
		while (node != null) {
			if (visited.contains(node)) {
				return node;
			}
			visited.add(node);
			node = node.next;
		}
		return null;
	}

	public static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

}
