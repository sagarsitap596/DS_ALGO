package com.sagar.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;


/**
 * insertKeyValuePair in O(1) time complexity
 * getValueFromKey in O(1) time complexity
 * getMostRecentKey in O(1) time complexity
 * 
 * 
 * @author sitapsha
 *
 */
public class LRUCache {

	int maxSize;
	Map<String, DoublyNode> cache = new HashMap<>();
	DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

	public boolean isFull() {
		return doublyLinkedList.count == maxSize;
	}

	public void updateCount() {
		doublyLinkedList.count++;
	}

	public LRUCache(int maxSize) {
		this.maxSize = maxSize > 1 ? maxSize : 1;
	}

	public void insertKeyValuePair(String key, int value) {
		/**
		 * If contains : Remove key from linkedList and set key as head of linkedList. 
		 * If not contains : 
		 * 		1. Remove tail,and from cache if no capacity.
		 * 		2. Add key to cache and set new key as head of linkedList. 
		 */
		if (cache.containsKey(key)) {
			DoublyNode node = cache.get(key);
			updateRecentAccessedKey(node);
			node.value = value;
		} else {
			DoublyNode node = new DoublyNode(key, value);
			if (isFull()) {
				String removedKey = doublyLinkedList.removeTail();
				cache.remove(removedKey);
			} else {
				updateCount();
			}
			doublyLinkedList.setHead(node);
			cache.put(key, node);
		}
	}
	
	/**
	 * If present (cache hit): set that key as head of linkedList.
	 * If not present return null 
	 * 
	 */
	public LRUResult getValueFromKey(String key) {
		if (cache.containsKey(key)) {
			updateRecentAccessedKey(cache.get(key));
			return new LRUResult(true, cache.get(key).value);
		}
		return new LRUResult(false, 0);
	}

	public String getMostRecentKey() {
		return doublyLinkedList.head != null ? doublyLinkedList.head.key : null;
	}
	
	public void updateRecentAccessedKey(DoublyNode node) {
		if (doublyLinkedList.head == node)
			return;
		if (doublyLinkedList.tail == node) {
			doublyLinkedList.removeTail();
		} else {
			node.deLink();
		}
		doublyLinkedList.setHead(node);
	}

	static class DoublyLinkedList {
		int count;
		DoublyNode head;
		DoublyNode tail;

		public void setHead(DoublyNode newNode) {
			if (head == null) {
				head = tail = newNode;
			} else {
				head.prev = newNode;
				newNode.next = head;
				head = newNode;
				head.prev = null; // if exiting node is to be made head than its prev should be made null
			}
		}

		public String removeTail() {
			if (tail == null)
				return null;

			String key = tail.key;
			if (head == tail) {
				head = tail = null;
			} else {
				tail = tail.prev;
				tail.next = null; // tail.next should always be null
			}
			return key;
		}
	}

	static class DoublyNode {
		String key;
		int value;
		DoublyNode prev;
		DoublyNode next;

		public DoublyNode(String key, int value) {
			this.key = key;
			this.value = value;
		}

		public void deLink() {

			if (prev != null) {
				prev.next = next;
			}
			if (next != null) {
				next.prev = prev;
			}
		}
	}

	static class LRUResult {
		boolean found;
		int value;

		public LRUResult(boolean found, int value) {
			this.found = found;
			this.value = value;
		}
	}

	public static void main(String[] args) {
		LRUCache lru = new LRUCache(3);
		System.out.println(lru.getMostRecentKey());
		lru.insertKeyValuePair("b", 2);
		lru.insertKeyValuePair("a", 1);
		lru.insertKeyValuePair("c", 3);

		System.out.println(lru.getMostRecentKey());
		System.out.println(lru.getValueFromKey("a").value);
		System.out.println(lru.getMostRecentKey());
		lru.insertKeyValuePair("d", 4);
		System.out.println(lru.getValueFromKey("b").value);
		lru.insertKeyValuePair("a", 5);
		System.out.println(lru.getValueFromKey("a").value);

	}
}
