package com.sagar.leetcode.linkedlist;


public class RemoveKthNodeFromEnd {

	
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

		// Recurrsion
		int idx = getIndex(head, 10);
		idx = idx + 1;
		if (idx == 10) {
			head.value = head.next.value;
			head.next = head.next.next;
		}
		print(head);
		
		// Non recurrsion
//		removeKthNodeFromEnd(head, 4);
//		print(head);
		
		
	}
	
	private static void print(LinkedList head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	private static int getIndex(LinkedList head, int k) {
		if (head == null) {
			return -1;
		}
		int idx = getIndex(head.next, k);
		idx = idx + 1;
		if (idx == k) {
			head.next = head.next.next;
		}
		return idx;
	}
	
	public static void removeKthNodeFromEnd(LinkedList head, int k) {
	    
		LinkedList first = head;
		LinkedList second = head;
		
		for(int i = 0 ; i < k ; i++){
				second = second.next;
		}
		
		if(second == null){
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while(second != null){
			second = second.next;
			if(second != null){
				first = first.next;
			}
		}
		
		first.next = first.next.next;
  }

	
	
	static class LinkedList {
		int value;
		LinkedList next = null;

		public LinkedList(int value) {
			this.value = value;
		}
	}

}
