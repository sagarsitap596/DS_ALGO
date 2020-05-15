package com.sagar.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Predicate can be used in all the contexts where an input object needs to be
 * evaluated for a given test condition and a boolean value needs to be returned
 * based on whether the condition was successfully met or not.
 * 
 * @author sitapsha
 *
 */
public class PredicateExample {

	public static void main(String args[]) {

		Predicate<Integer> isPositive = i -> i > 0;
		Predicate<Integer> isGreaterThan5 = i -> i > 5;
		Predicate<Integer> isEven = i -> i % 2 == 0;
		Predicate<Integer> isZero = Predicate.isEqual(0);
		
		Predicate<Integer> all = isPositive.and(isEven).and(isZero);

		List<Integer> integerList = Arrays.asList(0,1,4,5,7,12,14,20,-5,-3);
		
		List<Integer> filteredList = filterList(integerList, isPositive);
		System.out.println(filteredList);

		
		filteredList = filteredList.stream().filter(isPositive).collect(Collectors.toList());
		System.out.println(filteredList);
		
		filteredList = integerList.stream().filter(all).collect(Collectors.toList());
		System.out.println(filteredList);
		
		
		
	}

	public static List<Integer> filterList(List<Integer> listOfIntegers, Predicate<Integer> predicate) {
		List<Integer> filteredList = new ArrayList<Integer>();
		for (Integer integer : listOfIntegers) {
			if (predicate.test(integer)) {
				filteredList.add(integer);
			}
		}
		return filteredList;
	}

}
