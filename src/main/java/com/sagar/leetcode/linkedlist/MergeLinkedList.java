package com.sagar.leetcode.linkedlist;

public class MergeLinkedList {

	// 1 1 1 3 4 5 5 5 5 10
	// 1 1 2 2 5 6 10 10
	public static void main(String[] args) {
		LinkedList l1_1 = new LinkedList(1);
		LinkedList l1_2 = new LinkedList(1);
		LinkedList l1_3 = new LinkedList(1);
		LinkedList l3 = new LinkedList(3);
		LinkedList l4 = new LinkedList(4);
		LinkedList l5_1 = new LinkedList(5);
		LinkedList l5_2 = new LinkedList(5);
		LinkedList l5_3 = new LinkedList(5);
		LinkedList l5_4 = new LinkedList(5);
		LinkedList l10 = new LinkedList(10);

		LinkedList ll1_1 = new LinkedList(1);
		LinkedList ll1_2 = new LinkedList(1);
		LinkedList ll2_1 = new LinkedList(2);
		LinkedList ll2_2 = new LinkedList(2);
		LinkedList ll5 = new LinkedList(5);
		LinkedList ll6 = new LinkedList(6);
		LinkedList ll10_1 = new LinkedList(10);
		LinkedList ll10_2 = new LinkedList(10);

		LinkedList head1 = l1_1;
		l1_1.next = l1_2;
		l1_2.next = l1_3;
		l1_3.next = l3;
		l3.next = l4;
		l4.next = l5_1;
		l5_1.next = l5_2;
		l5_2.next = l5_3;
		l5_3.next = l5_4;
		l5_4.next = l10;

		LinkedList head2 = ll1_1;
		ll1_1.next = ll1_2;
		ll1_2.next = ll2_1;
		ll2_1.next = ll2_2;
		ll2_2.next = ll5;
		ll5.next = ll6;
		ll6.next = ll10_1;
		ll10_1.next = ll10_2;

		print(head1);
		print(head2);
		LinkedList newHead = mergeLinkedLists(head1, head2);
		print(newHead);
	}

	private static void print(LinkedList head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	// This is with creating new list. i.e not mutating any of original list
	// Time complexity = O(n+m)
	// spcae = O(1)
	public static LinkedList mergeLinkedLists1(LinkedList headOne, LinkedList headTwo) {

		LinkedList head = new LinkedList(-1);
		LinkedList current = head;

		while (headOne != null && headTwo != null) {
			if (headOne.value < headTwo.value) {
				current.next = headOne;
				headOne = headOne.next;
			} else {
				current.next = headTwo;
				headTwo = headTwo.next;
			}
			current = current.next;
		}

		if (headOne != null) {
			current.next = headOne;
			headOne = headOne.next;
		} else if (headTwo != null) {
			current.next = headTwo;
			headTwo = headTwo.next;
		}
		return head.next;
	}

	// This is without creating ne list. i.e mutating first list.
	// Time complexity = O(n+m)
	// spcae = O(1)
	public static LinkedList mergeLinkedLists(LinkedList headOne, LinkedList headTwo) {

		// we will mutate first linked list.
		// insert headTwo.valu before headOne.value. So we need prev node of
		// headOne.value
		LinkedList prev = null;
		LinkedList first = headOne;
		LinkedList second = headTwo;

		while (first != null && second != null) {
			if (first.value > second.value) {
				if (prev != null) {
					prev.next = second;
				}
				prev = second;
				second = second.next;
				prev.next = first;
			} else {
				prev = first;
				first = first.next;
			}
		}
		// if headOne has reached null than append all ramaining nodes of headTwo
		// directly
		// if headTwo has reached null than we don need to anything as we are mutating
		// first LinkList only.
		if (first == null) {
			prev.next = second;
		}
		// if headTwo is strictly greater that headOne than we are appendinf headTwo
		// before heeadOne So Head is headTwo
		return headOne.value > headTwo.value ? headTwo : headOne;
	}

	public static class LinkedList {
		int value;
		LinkedList next;

		LinkedList(int value) {
			this.value = value;
			this.next = null;
		}
	}

}
