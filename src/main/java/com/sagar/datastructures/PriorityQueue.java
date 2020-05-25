package com.sagar.datastructures;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {

	private List<Integer> list = new ArrayList<>();

	private void heapify(int parentIndex) {
		int largestPriorityIndex = parentIndex;
		int leftChildIndex = (2 * parentIndex) + 1;
		int rightChildIndex = (2 * parentIndex) + 2;

		if (leftChildIndex < list.size() && list.get(leftChildIndex) > list.get(largestPriorityIndex)) {
			largestPriorityIndex = leftChildIndex;
		}
		if (rightChildIndex < list.size() && list.get(rightChildIndex) > list.get(largestPriorityIndex)) {
			largestPriorityIndex = rightChildIndex;
		}

		if (largestPriorityIndex != parentIndex) {
			// swap
			int temp = list.get(largestPriorityIndex);
			list.set(largestPriorityIndex, list.get(parentIndex));
			list.set(parentIndex, temp);
			heapify(largestPriorityIndex);
		}
	}

	private void insert(Integer data) {
		if (list.isEmpty())
			list.add(data);
		else {
			list.add(data);
			int numberOfParents = (list.size() / 2) - 1;
			// since we added data at end of list. heapify complete heap
			for (int i = numberOfParents; i >= 0; i--) {
				heapify(i);
			}
		}
	}

	private Integer remove() {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("Priority Queue is empty");
		} else {
			int data = list.get(0);
			list.set(0, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			int numberOfParents = (list.size() / 2) - 1;
			// since we added data at end of list. heapify complete heap
			for (int i = numberOfParents; i >= 0; i--) {
				heapify(i);
			}
			return data;
		}
	}

	private Integer remove(Integer data) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("Priority Queue is empty");
		} else {
			int i;
			for (i = 0; i < list.size(); i++) {
				if (list.get(i).equals(data)) {
					break;
				}
			}
			list.set(i, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			int numberOfParents = (list.size() / 2) - 1;
			// since we added data at end of list. heapify complete heap
			for (int j = numberOfParents; j >= 0; j--) {
				heapify(j);
			}
			return data;
		}
	}

	// Print the tree
	void printArray() {
		for (Integer i : list) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		PriorityQueue pq = new PriorityQueue();

		pq.insert(3);
		pq.insert(4);
		pq.insert(9);
		pq.insert(5);
		pq.insert(2);

		System.out.println("Max-Heap array: ");
		pq.printArray();

		pq.remove(4);
		System.out.println("After deleting an element : 4 ");
		pq.printArray();
		System.out.println("After deleting max priority  element : ");
		pq.remove();
		pq.printArray();
		System.out.println("Adding 201");
		pq.insert(201);
		pq.printArray();
		System.out.println("After deleting max priority  element : ");
		pq.remove();
		pq.printArray();

	}

}
