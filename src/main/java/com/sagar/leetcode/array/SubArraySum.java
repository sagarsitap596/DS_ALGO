package com.sagar.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

public class SubArraySum {

	public static void main(String[] args) {
		int[] r = twoSumInSortedArray(new int[] { 2, 7, 11, 15 }, 9);
		System.out.println(r[0] + " " + r[1]);

		int[] c = twoSumInUnsortedArray(new int[] { 15, 11, 9, 6, 0, 10, 5 }, 15);
		System.out.println(c[0] + " " + c[1]);

//		int t = subarraySum(new int[] { 15, 11, 9, 6, 0,0, 10, 5 }, 15);
		int t = subarraySum(new int[] { 9, 6, 0, 0, 10, 5 }, 15);// [9,6],[9,6,0],[9,6,0,0],[0,0,10,5],[0,10, 5],[]10, 5
		System.out.println(t);

		uniquePairSumInUnsortedArray(new int[] { 1, 5, 1, 5 }, 6);

	}

	/**
	 * https://www.youtube.com/watch?v=N6EzbSxD6Bg
	 * 
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> sumCount = new HashMap<>();
		sumCount.put(0, 1);
		int finalCount = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];

			if (sumCount.containsKey(sum - k)) {
				finalCount = finalCount + sumCount.get(sum - k);
			}
			sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
		}
		return finalCount;
	}

	public static int[] twoSumInSortedArray(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length - 1;

		while (i < j) {
			int sum = numbers[i] + numbers[j];
			if (sum == target) {
				return new int[] { numbers[i], numbers[j] };
			} else if (sum < target) {
				i++;
			} else {
				j--;
			}
		}
		return new int[2];
	}

	public static int[] twoSumInUnsortedArray(int[] nums, int target) {

		HashMap<Integer, Integer> encountered = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (encountered.containsKey(target - nums[i])) {
				return new int[] { encountered.get(target - nums[i]), i };
			}
			encountered.put(nums[i], i);
		}
		return new int[2];
	}

	public static void uniquePairSumInUnsortedArray(int[] nums, int target) {

		HashSet<Integer> encountered = new HashSet<>();

		for (int num : nums) {
			if (!encountered.contains(num) && encountered.contains(target - num)) {
				System.out.println("[ " + nums + " , " + (target - num) + " ]");
			}
			encountered.add(num);
		}
	}

}
