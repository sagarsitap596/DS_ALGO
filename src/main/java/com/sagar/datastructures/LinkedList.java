package com.sagar.datastructures;

import java.util.HashMap;
import java.util.Map;

public class LinkedList {
	Node head;
	Node tail;
	int count;

	public void addFirst(Node node) {
		if (node == null) {
			throw new IllegalArgumentException("Cannit be null");
		}
		if (head == null) {
			head = node;
			count++;
		} else {
			node.nextNode = head;
			head = node;
			count++;
		}
	}

	public void add(Node newNode) {
		if (newNode == null) {
			throw new IllegalArgumentException("Cannit be null");
		}
		if (head == null) {
			head = tail = newNode;
		} else {
			tail.nextNode = newNode;
			tail = newNode;
			count++;
//			Node temp = head;
//			while (temp != null) {
//				if (temp.nextNode == null) {
//					temp.nextNode = newNode;
//					count++;
//					return;
//				} else {
//					temp = temp.nextNode;
//				}
//			}
		}
	}

	public boolean remove(Node node) {
		if (node == null) {
			throw new IllegalArgumentException("Cannot be null");
		}
		if (count > 0) {
			if (head.equals(node)) {
				head = head.nextNode;
			} else {
				Node current = head;
				Node previous = head;
				while (current != null) {
					if (node.equals(current)) {
						previous.nextNode = current.nextNode;
						count--;
						if (node == tail) {
							tail = previous;
						}
						return true;
					}
					previous = current;
					current = current.nextNode;
				}
			}
		}
		return false;
	}

	public boolean remove(int index) {
		if (index < 0 || index >= count) {
			throw new IllegalArgumentException("Invalid index");
		} else if (index == 0) {
			head = head.nextNode;
			count--;
		} else {
			int n = 0;
			Node temp = head;
			while (n < index) {
				if (n == index - 1) {
					if (temp.nextNode == tail) {
						tail = temp;
					}
					temp.nextNode = temp.nextNode.nextNode;
					count--;
					return true;
				} else {
					temp = temp.nextNode;
				}
				n++;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		if (head == null) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");

		Node temp = head;
		while (temp != null) {
			sb.append(temp.data);
			sb.append("  ");
			temp = temp.nextNode;
		}
		sb.append("]");
		return sb.toString();

	}

	public boolean contains(Node node) {
		if (node == null) {
			throw new IllegalArgumentException("Cannot be null");
		}
		if (count > 0) {
			Node temp = head;
			while (temp != null) {
				if (node.equals(temp)) {
					return true;
				} else {
					temp = temp.nextNode;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
//		ll.add(new Node("a"));
//		ll.add(new Node("b"));
//		ll.add(new Node("c"));
//		ll.add(new Node("d"));
//		ll.add(new Node("e"));
//		ll.addFirst(new Node("Z"));
//
//		System.out.println(ll);
//
//		ll.remove(new Node("c"));
//		ll.remove(new Node("e"));
//		ll.remove(new Node("Z"));
//		System.out.println(ll);
//
//		ll.remove(2);
//		ll.remove(0);
//		System.out.println(ll);
//
//		System.out.println(ll.contains(new Node("ee")));

		Map<Node,String> m= new HashMap<>();
		System.out.println(hash("a"));
		m.put(new Node("a"), "aa");
		
	}
	
	static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}

class Node {
	String data;
	Node nextNode;

	public Node(String data) {
		super();
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

}
