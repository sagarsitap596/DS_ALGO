package com.sagar.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/*
 * Consumer takes input and performs operation on it. It does not return anything.
 * used in forEach()
 * 
 * https://www.javabrahman.com/java-8/java-8-java-util-function-consumer-tutorial-with-examples/
 */
public class ConsumerExample {

	public static void main(String args[]) {
		Consumer<Integer> consumer = i -> System.out.print(" " + i);
		Consumer<Integer> consumerWithAndThen = consumer.andThen(i -> System.out.print("(printed " + i + ")"));
		List<Integer> integerList = Arrays.asList(new Integer(1), new Integer(10), new Integer(200), new Integer(101),
				new Integer(-10), new Integer(0));
		printList(integerList, consumerWithAndThen);

		System.out.println("===================================");

		integerList.stream().forEach(consumer.andThen(consumerWithAndThen));
	}

	public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
		for (Integer integer : listOfIntegers) {
			consumer.accept(integer);
		}
	}

}
