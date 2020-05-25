package com.sagar.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapValueSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> data = new HashMap<>();
		data.put("A", 4);
		data.put("B", 8);
		data.put("C", 1);
		data.put("D", 5);
		data.put("E", 4);

		System.out.println(sortByValue(data));
		System.out.println(sortByValue(data));
	}

	public static Map<? extends Object, ? extends Object> sortByValue(Map<? extends Object, ? extends Number> input) {

		return input.entrySet().stream()
				.sorted((k1, k2) -> -((Integer) k1.getValue()).compareTo((Integer) k2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

	}

	public static Map<String, Integer> sortByValue2(Map<String, Integer> data) {

		return data.entrySet().stream().sorted((k1, k2) -> k1.getValue().compareTo(k2.getValue())).collect(Collectors
				.toMap(entry -> entry.getKey(), entry -> entry.getValue(), (k1, k2) -> k2, LinkedHashMap::new));
	}

}
