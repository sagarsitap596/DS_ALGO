package com.sagar.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets {

	public static void main(String[] args) {

		int[] nums = new int[] { 1, 2, 3 };
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for (int n : nums) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> nw = new ArrayList<>(result.get(i));
				nw.add(n);
				result.add(nw);
			}
		}
		System.out.println(result);

	}

}
