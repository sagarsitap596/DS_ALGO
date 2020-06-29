package com.sagar.datastructures;

public class DoublyLinkedList {
	public Node head;
	public Node tail;

	public void setHead(Node node) {
		if (head == null) {
			head = tail = node;
			return;
		}
		insertBefore(head, node);
	}

	public void setTail(Node node) {
		if (head == null) {
			head = tail = node;
			return;
		}
		Node current = head;
		while (current != null) {
			if (current.value == node.value) {
				remove(current);
				break;
			}
			current = current.next;
		}
		insertAfter(tail, node);
	}

	public void insertBefore(Node node, Node nodeToInsert) {

		Node current = head;
		while (current != null) {
			if (current.value == nodeToInsert.value) {
				remove(current);
				break;
			}
			current = current.next;
		}
		updateLink(node.prev, nodeToInsert, node);

	}

	public void insertAfter(Node node, Node nodeToInsert) {
//				Node current = head;
//				while (current != null) {
//					if (current.value == nodeToInsert.value) {
//						remove(current);
//						break;
//					}
//					current = current.next;
//				}
		updateLink(node, nodeToInsert, node.next);
	}

	public void insertAtPosition(int position, Node nodeToInsert) {

		if (position == 1) {
			if (head == null) {
				head = tail = nodeToInsert;
			} else {
				head.prev = nodeToInsert;
				nodeToInsert.next = head;
				head = nodeToInsert;
			}
			return;
		}

		int i = 2;
		Node current = head.next;
		while (current != null) {
			if (i == position) {
				updateLink(current.prev, nodeToInsert, current);
				return;
			}
			current = current.next;
			i++;
		}
	}

	public void removeNodesWithValue(int value) {

		Node current = head;
		while (current != null) {
			Node nodeToRemove = current; // since that node will be gone and we also have to do current =
											// current.next;
			current = current.next;
			if (nodeToRemove.value == value) {
				remove(nodeToRemove);
			}
		}
	}

	public void remove(Node node) {
		if (head == node)
			head = node.next; // head
		if (tail == node)
			tail = tail.prev; // tail

		if (node.prev != null) { // not head node
			node.prev.next = node.next;
		}
		if (node.next != null) { // not tail node
			node.next.prev = node.prev;
		}
		node.prev = null; // del ref
		node.next = null; // del ref
	}

	public boolean containsNodeWithValue(int value) {
		if (head == null)
			throw new RuntimeException("Empty list");

		Node current = head;
		while (current != null) {
			if (current.value == value) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	private void updateLink(Node node1, Node newNode, Node node2) {

		newNode.prev = node1;
		newNode.next = node2;
		if (node1 == null) {
			head = newNode;
		} else {
			node1.next = newNode;
		}

		if (node2 == null) {
			tail = newNode;
		} else {
			node2.prev = newNode;
		}
	}

	public Node get(int val) {
		Node curr = head;
		while (curr != null) {
			if (curr.value == val) {
				return curr;
			}
			curr = curr.next;
		}
		return null;
	}

	// Do not edit the class below.
	static class Node {
		public int value;
		public Node prev;
		public Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		DoublyLinkedList dl = new DoublyLinkedList();
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		dl.head = n1;
		dl.tail = n5;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		n5.prev = n4;
		n4.prev = n3;
		n3.prev = n2;
		n2.prev = n1;
		dl.print();
		//////////////////////////////////////////////

//		dl.setHead(n4);
//		dl.print();
//		dl.setTail(new Node(6));
//		dl.print();
//		dl.insertBefore(dl.get(6), dl.get(3));
//		dl.print();
//		dl.insertAfter(dl.get(6), new Node(3));
//		dl.print();
//		dl.insertAtPosition(1, new Node(3));
//		dl.print();
//		dl.removeNodesWithValue(3);
//		dl.print();
//		dl.remove(dl.get(2));
//		dl.print();
//		System.out.println(dl.containsNodeWithValue(5));

		dl.setHead(n4);
		dl.print();
		dl.setTail(new Node(6));
		dl.print();
		dl.insertBefore(dl.get(6), dl.get(3));
		dl.print();
		dl.insertAfter(dl.get(6), new Node(3));
		dl.print();
		dl.insertAtPosition(1, new Node(3));
		dl.print();
		dl.removeNodesWithValue(3);
		dl.print();
		dl.remove(dl.get(2));
		dl.print();
		System.out.println(dl.containsNodeWithValue(5));

	}

	public void print() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();
	}
}
