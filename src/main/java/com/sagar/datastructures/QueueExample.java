package com.sagar.datastructures;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueExample {

	public static void main(String[] args) {
		
		java.util.LinkedList<String> l = new java.util.LinkedList<>();
	
		// LinkedList implementation of Queue
		Queue<String> animal1 = new java.util.LinkedList<>();

		// Array implementation of Queue
		Queue<String> animal2 = new ArrayDeque<>();

		// Priority Queue implementation of Queue
		Queue<String> animal3 = new java.util.PriorityQueue<>();

		l.add("1");
		l.add("3");
		l.add("5");
		System.out.println(l);
		
		System.out.println(l.removeFirst());
		System.out.println(l.removeFirst());
		System.out.println(l.removeFirst());
		System.out.println("=====================");
		
		animal1.offer("1");
		animal1.offer("3");
		animal1.offer("5");
		System.out.println(animal1.poll());
		System.out.println(animal1.poll());
		System.out.println(animal1.poll());
		System.out.println("=====================");

		animal2.offer("1");
		animal2.offer("3");
		animal2.offer("5");

		System.out.println(animal2.poll());
		System.out.println(animal2.poll());
		System.out.println(animal2.poll());
		System.out.println("=====================");

		animal3.offer("1");
		animal3.offer("3");
		animal3.offer("5");

		System.out.println(animal3.poll());
		System.out.println(animal3.poll());
		System.out.println(animal3.poll());
		System.out.println("=====================");
	}

}
