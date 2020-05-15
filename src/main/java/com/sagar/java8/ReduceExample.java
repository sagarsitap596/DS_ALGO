package com.sagar.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReduceExample {

	public static void main(String[] args) {

		List<Integer> ls = Arrays.asList(1, 2, 3, 4);

		double sum = ls.stream().reduce(1, (n1, n2) -> n1 + n2);
		System.out.println(sum);

		double max = ls.stream().max(Comparator.naturalOrder()).get();
		max = ls.stream().reduce(Integer::max).get();
		double min = ls.stream().min(Comparator.naturalOrder()).get();
		min = ls.stream().reduce(Integer::min).get();

	}

}
