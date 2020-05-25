package com.sagar.sort;

/**
 * 
 * left child = 2n + 1 right child = 2n + 2
 * 
 * parent = n-1 / 2
 * 
 * there will be total (n/2) - 1 parent nodes. Or the last parent is at index
 * (n/2) - 1
 * 
 * 
 * @author sitapsha
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 3, 7, 2, 5, 2, 7, 4, 8 };

		// Step 1 : Convert array into max heap. such that every parent is greter than
		// its child.
		// arr[0] > arr[1] , arr[2]
		// arr[1] > arr[3] , arr[4]
		// arr[2] > arr[5] , arr[6]
		// arr[3] > arr[7]

		for (int i = (arr.length / 2) - 1; i >= 0; i--) {
			System.out.println("heapifying parent at index: " + i);
			heapify(arr, i, arr.length);
		}

		// Step 2 : swap arr[0] (mapx heap has largest element at root) with last
		// element
		// (so that we have sorted last element.)
		// step 3 : heapify root (since in step 2 we swapped so the root node is no
		// longer largest.)

		for (int i = arr.length - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, 0, i);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	/**
	 * Assumes that all the sub trees are max heap.
	 */
	private static void heapify(int[] arr, int parentIndex, int length) {

		int leftChildIndex = (2 * parentIndex) + 1;
		int rightChildIndex = (2 * parentIndex) + 2;
		int largestIndex = parentIndex;

		if (leftChildIndex < length && arr[leftChildIndex] > arr[largestIndex]) {
			largestIndex = leftChildIndex;
		}
		if (rightChildIndex < length && arr[rightChildIndex] > arr[largestIndex]) {
			largestIndex = rightChildIndex;
		}

		// there is a child whose value is larger than parent
		if (largestIndex != parentIndex) {
			int temp = arr[parentIndex];
			arr[parentIndex] = arr[largestIndex];
			arr[largestIndex] = temp;
			heapify(arr, largestIndex, length);// heapify the node(arr[parentIndex] -- the one got replaced at child)
												// which
		}
	}
}
