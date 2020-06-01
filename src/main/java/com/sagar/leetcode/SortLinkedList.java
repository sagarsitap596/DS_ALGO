package com.sagar.leetcode;

public class SortLinkedList {

	public static void main(String[] args) {

		Node n6 = new Node(1, null);
		Node n5 = new Node(3, n6);
		Node n4 = new Node(2, n5);
		Node n3 = new Node(6, n4);
		Node n2 = new Node(4, n3);
		Node n1 = new Node(5, n2);

		Node head = n1;
		head = sortLinkedList(n1);

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

	}

	static private Node sortLinkedList(Node head) {

		if (head == null || head.next == null) {
			return head;
		}
		// we will use merge sort algo
		// divide linkedList into two halves
		Node first_tail = head;
		Node second_head = head;
		Node second_tail = head;

		// when above loop ends we get first_tail points to middle node
		while (second_tail != null && second_tail.next != null) {
			first_tail = second_head;
			second_head = second_head.next; // one step at a time
			second_tail = second_tail.next.next; // two steps at a time
		}
		first_tail.next = null;

		Node left_node = sortLinkedList(head);
		Node right_node = sortLinkedList(second_head);

		return merge(left_node, right_node);

	}

	private static Node merge(Node left_node, Node right_node) {
		Node sorted_list = new Node(-1, null);
		Node temp = sorted_list; // this req so that we can have assign original head point to sorted head.
		while (left_node != null && right_node != null) {

			if (left_node.data < right_node.data) {
				sorted_list.next = left_node;
				left_node = left_node.next;
			} else {
				sorted_list.next = right_node;
				right_node = right_node.next;
			}
			sorted_list = sorted_list.next;
		}

		if (left_node != null) {
			sorted_list.next = left_node;
			left_node = left_node.next;
		}
		if (right_node != null) {
			sorted_list.next = right_node;
			right_node = right_node.next;
		}
		return temp.next;

	}
}

class Node {
	Integer data;
	Node next;

	public Node(Integer data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}

}
