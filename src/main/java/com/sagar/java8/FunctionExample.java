package com.sagar.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * Function Takes input and return output. Used in map()
 * 
 * https://www.javabrahman.com/java-8/function-descriptors-java-8-explained/
 * 
 * @author sitapsha
 *
 */
public class FunctionExample {

	public static void main(String[] args) {
		/**
		 * Function <input data type, output data type>
		 */
		Function<String, Integer> convertToInteger = s -> Integer.valueOf(s);

		Function<Integer, String> convertToString = n -> String.valueOf(n);

		Function<Integer, Integer> findSquare = n -> n * n;

		Function<Integer, Double> findSquareRoot = n -> Math.sqrt(n);

		Function<String, String> appendZero = s -> s + "0";

		/*
		 * andThen applies convertToInteger first and then findSquare
		 */
		Function<String, Integer> covertToIntegerAndSquare = convertToInteger.andThen(findSquare);

		/**
		 * compose applies convertToInteger first and then findSquare
		 */
		Function<String, Integer> covertToIntegerAndSquare2 = findSquare.compose(convertToInteger);

		List<String> numbers = Arrays.asList("1", "2", "3", "4");

		numbers.stream().map(covertToIntegerAndSquare).forEach(System.out::println);
		System.out.println("==============================================");
		numbers.stream().map(covertToIntegerAndSquare2).forEach(System.out::println);
		System.out.println("==============================================");

		// sequence ->
		// convertToInteger,findSquare,convertToString,appendZero,convertToInteger,findSquareRoot
		numbers.stream().map(findSquareRoot.compose(convertToInteger.andThen(findSquare).andThen(convertToString)
				.andThen(appendZero).andThen(convertToInteger))).forEach(System.out::println);

		numbers.stream().map(Function.identity()).forEach(System.out::println);
		System.out.println("==============================================");
		
		
		
		// BiFunction

		BiFunction<String, String, Integer> appendAndConvertToInteger = (s1, s2) -> Integer.parseInt(s1 + s2);

		System.out.println(findSquare.apply(appendAndConvertToInteger.apply("11", "22")));

		Function<String, String> findSquareAndPrint = n -> {
			System.out.println(n + "_updated");
			return n + "_updated";
		};

		System.out.println(numbers.stream().map(findSquareAndPrint).count());
	}

}
