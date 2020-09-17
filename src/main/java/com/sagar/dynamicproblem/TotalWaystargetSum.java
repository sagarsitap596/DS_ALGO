package com.sagar.dynamicproblem;

import java.util.HashMap;
import java.util.Map;

public class TotalWaystargetSum {

	public static void main(String[] args) {
		Map<Integer, Integer> memorized = new HashMap<Integer, Integer>();
		System.out.println(solve(6, memorized));
//		System.out.println(solve(3));
		System.out.println();
	}

	private static int solve(int n, Map<Integer, Integer> memorized) {
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		if (memorized.containsKey(n))
			return memorized.get(n);

		int totalWays = solve(n - 1, memorized) + solve(n - 3, memorized) + solve(n - 5, memorized);
		memorized.put(n, totalWays);
		return totalWays;
	}

	private static int solve(int n) {
		if (n < 1)
			return 0;
		if (n == 1)
			return 1;
		return solve(n - 1) + solve(n - 3) + solve(n - 5);
	}

}
