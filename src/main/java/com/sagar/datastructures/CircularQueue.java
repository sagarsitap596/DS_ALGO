package com.sagar.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * remove from front insert from rear
 *
 */
public class CircularQueue {

	int front = -1;
	int rear = -1;
	String[] arr;

	public CircularQueue(int size) {
		arr = new String[size];
	}

	public boolean isFull() {
		if (front == 0 && rear == arr.length - 1) {
			return true;
		} else if (rear + 1 == front) {
			return true;
		} else
			return false;
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public void enqueue(String data) {
		if (isFull()) {
			throw new IllegalArgumentException("Queue Overflow");
		} else if (isEmpty()) {
			arr[0] = data;
			front = rear = 0;
		} else {
			int newIndex = (rear + 1) % arr.length;
			if (newIndex == front) {
				throw new IllegalArgumentException("Queue Overflow");
			}
			arr[newIndex] = data;
			rear = newIndex;
		}
	}

	public void dequeue() {
		if (isEmpty()) {
			throw new IllegalArgumentException("Queue is empty");
		}
		if (rear == front) {
			arr[rear] = null;
			front = rear = -1;
		} else {
			arr[front] = null;
			front = (front + 1) % arr.length;
		}
	}

	public static void main(String[] args) {
		CircularQueue cq = new CircularQueue(3);
		cq.enqueue("a");
		cq.enqueue("b");
		cq.enqueue("c");
		cq.dequeue();
		cq.enqueue("d");
		cq.dequeue();
		cq.dequeue();
		cq.enqueue("e");
		cq.dequeue();
		cq.dequeue();
		cq.enqueue("f");
	}

	@Override
	public String toString() {
		String s = "[ ";
		for (int i = 0; i < arr.length; i++) {
			s = s + arr[i] + "  ";
		}
		return s + "]";
	}

}
