package com.sagar.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	// 0 1 1 2 3 5 8 13 21
	// 1st 2nd 3rd
	public static void main(String[] args) {

		System.out.println(fibo1(10));
		System.out.println("====");
		System.out.println(fibo2(10, new HashMap<Integer, Long>()));
		System.out.println("====");
		System.out.println(fibo3(10));
		System.out.println("====");
		System.out.println(fibo4(10));

	}

	/*
	 * time complexity is O(2 ^ n) space complexity is O(n) due to Map
	 */
	private static long fibo1(int n) {

		if (n == 1)
			return 0;
		if (n == 2)
			return 1;

		return fibo1(n - 2) + fibo1(n - 1);

	}

	/*
	 * time complexity is O(n) space complexity is O(n) due to Map
	 */
	private static long fibo2(int n, Map<Integer, Long> cache) {

		if (n == 1)
			return 0;
		if (n == 2)
			return 1;

		if (cache.containsKey(n))
			return cache.get(n);

		long f = fibo2(n - 2, cache) + fibo2(n - 1, cache);
		cache.put(n, f);
		return f;

	}

	/*
	 * time complexity is O(n) space complexity is O(1)
	 */
	private static long fibo3(int n) {
		long a = 0;
		long b = 1;
		long c = 0;

		if (n == 1)
			return a;
		if (n == 2)
			return b;

		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}

		return b;
	}

	/*
	 * time complexity is O(n) space complexity is O(1)
	 */
	private static int fibo4(int n) {
		int[] cache = { 0, 1 };

		for (int i = 3; i <= n; i++) {
			int nextVal = cache[0] + cache[1];
			cache[0] = cache[1];
			cache[1] = nextVal;
		}
		return n <= 1 ? cache[0] : cache[1];
	}

}
