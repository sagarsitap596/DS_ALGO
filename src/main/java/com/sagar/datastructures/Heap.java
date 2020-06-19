package com.sagar.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.youtube.com/watch?v=W81Qzuz4qH0
 * 
 * left child = 2n+1 right child = 2n+2 parent = (n-1)/2
 * 
 * @author sitapsha
 *
 */
public class Heap {
	private List<Integer> list = new ArrayList<>();

	/**
	 * This method heapify given node and if the given node is at right place it
	 * does nothing. Else it rearrange positions and call recursively heapify for
	 * rearranged node.
	 * 
	 * @param parentIndex
	 */
	private void heapifyDown(int parentIndex) {

		int largestIndex = parentIndex;
		int leftIndex = (2 * parentIndex) + 1;
		int rightIndex = (2 * parentIndex) + 2;

		if (leftIndex < list.size() && list.get(largestIndex) < list.get(leftIndex)) {
			largestIndex = leftIndex;
		}
		if (rightIndex < list.size() && list.get(largestIndex) < list.get(rightIndex)) {
			largestIndex = rightIndex;
		}

		if (largestIndex != parentIndex) {
			Integer temp = list.get(parentIndex);
			list.set(parentIndex, list.get(largestIndex));
			list.set(largestIndex, temp);

			// largestIndex is the node we replace data with parent. so heapifiy child sub
			// tree with largestIndex has parent
			heapifyDown(largestIndex);
		}
	}

	public void insert(Integer val) {
		list.add(val);
		heapifyUp(list.size() - 1);
	}

	private void heapifyUp(int index) {
		int parent = (index - 1) / 2;

		// since heap was alreay max heap so existing chil is less than parent.
		// we just check new node is greater than parent or not
		if (parent >= 0 && list.get(parent) < list.get(index)) {
			Integer temp = list.get(parent);
			list.set(parent, list.get(index));
			list.set(index, temp);
			heapifyUp(parent);
		}
	}

	/**
	 * Always return root element (smaller in case if min heap and max in case of
	 * max heap)
	 * 
	 */
	public Integer remove() {
		if (list.isEmpty())
			throw new RuntimeException("Heap is empty");
		Integer temp = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.get(list.size() - 1));
		heapifyDown(0);
		return temp;
	}

	public Integer peek() {
		if (list.isEmpty())
			throw new RuntimeException("Heap is empty");
		return list.get(0);
	}

	public int height(int index) {
		if (index > list.size() - 1) {
			return -1;
		}
		int leftSubTreeHeight = height((2 * index) + 1);
		int rightSubTreeHeight = height((2 * index) + 2);
		return Math.max(leftSubTreeHeight, rightSubTreeHeight) + 1;
	}

	public void print() {
		int height = height(0);
		int count = 0;
		for (int i = 0; i <= height; i++) {
			for (double j = Math.pow(2, height - i); j >= 0; j--) {
				System.out.print(" ");
			}
			for (double k = 0; k < Math.pow(2, i); k++) {
				if (count < list.size()) {
					System.out.print(list.get(count) + "   ");
					count++;
				}
			}
			System.out.println();
		}

		System.out.println("=============================");
	}

	public static void main(String[] args) {
		Heap maxheap = new Heap();

		maxheap.insert(5);
		maxheap.print();
		maxheap.insert(19);
		maxheap.print();
		maxheap.insert(3);
		maxheap.print();
		maxheap.insert(87);
		maxheap.print();
		maxheap.insert(33);
		maxheap.print();
		maxheap.insert(20);
		maxheap.print();
		maxheap.insert(1);
		maxheap.print();
		System.out.println("Height : " + maxheap.height(0));
		System.out.println(maxheap.peek());
		maxheap.remove();

		System.out.println(maxheap.peek());

		System.out.println("Height : " + maxheap.height(0));

	}

}
