package com.sagar.java8;

import java.util.ArrayList;
import java.util.List;

public class StreamExample {

	public static void main(String[] args) {
		/**
		 * Collections.forEach vs stream().forEach -- - Collections.forEach iterates
		 * based on order defined in that colections iteration. - stream().forEach dont
		 * follow iteratior order. -
		 * https://www.baeldung.com/java-collection-stream-foreach
		 * 
		 * - both fails on adding/deleting element from list. - both dont fail for
		 * updating any value
		 * 
		 */

		List<Integer> ls = new ArrayList<>();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		ls.add(4);

		/**
		 * ConcurrentModificationException is thrown after processing all elements.
		 */
		ls.stream().forEach(n -> {
			System.out.print(n + " ");
			if (n == 2) {
				ls.add(5);
			}
		});

		/**
		 * ConcurrentModificationException is thrown immediately
		 */
		ls.forEach(n -> {
			System.out.print(n + " ");
			if (n == 2) {
				ls.add(5);
			}
		});

		/**
		 * - both dont fail for updating any value
		 */
		ls.stream().forEach(n -> {
			if (n == 3) {
				ls.set(1, 22);
				ls.set(2, 33);
				ls.set(3, 44);
			}
		});
		System.out.println(ls);

		ls.forEach(n -> {
			if (n == 3) {
				ls.set(1, 222);
				ls.set(2, 333);
				ls.set(3, 444);
			}
		});

		System.out.println(ls);
		
		/**
		 * each element flows through one at a time.
		 */
		ls.stream().peek(n -> {System.out.println(n+"--1");}).forEach(n -> {System.out.println(n+"--2	");});

	}

}
