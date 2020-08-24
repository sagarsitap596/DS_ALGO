package com.sagar.concurrency.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Adding an item to the list:<br>
 * List< ? extends X > doesn't allow to add anything, except for null into the
 * list.<br>
 * List< ? super X > allows to add anything that is-a X (X or its subtype), or
 * null.<br>
 * <br>
 * 
 * Getting an item from the list:<br>
 * When you get an item from List< ? extends X >, you can assign it to a
 * variable of type X or any supertype of X, including Object.<br>
 *
 * When you get an item from List< ? super X >, you can only assign it to a
 * variable of type Object.<br>
 * 
 * 
 * The Get and Put Principle: use an extends wildcard when you only get values
 * out of a structure, use super wildcard when you only put values into a
 * structure, and don't use a wildcard when you both get and put.
 * 
 * @author sitapsha
 *
 */
public class GenericsExample {

	public static void main(String[] args) {
//		List<? extends Number> list1 = new ArrayList<Integer>();
//		list1.add(null); // OK
//		Number n = list1.get(0); // OK
//		Serializable s = list1.get(0); // OK
//		Number o = list1.get(0); // OK
//
//		list1.add(2.3); // ERROR
//		list1.add(5); // ERROR
//		list1.add(new Object()); // ERROR
//		Integer i = list1.get(0); // ERROR
//
//		// ==============================================================
//
//		List<? super Number> list2 = new ArrayList<Number>();
//		list2.add(null); // OK
//		list2.add(2.3); // OK
//		list2.add(5); // OK
//		Object o1 = list2.get(0); // OK
//
//		list2.add(new Object()); // ERROR
//		Number n1 = list2.get(0); // ERROR
//		Serializable s1 = list2.get(0); // ERROR
//		Integer i1 = list2.get(0); // ERROR

		addIfPresent(new ArrayList<Integer>(), 1);
		addIfPresent(new ArrayList<Double>(), 1.1);

	}

	private static <T> void addIfPresent(List<? super T> list, T element) {

		if (Objects.nonNull(element)) {
			list.add(element);
			System.out.println(list);
		}
	}

}
