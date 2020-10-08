package com.sagar.amazon;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Time complexity : O(nlog n) for sort, O(nlog n) for flightsInAir === 2nlogn =
 * n logn Space complexity : O(n)
 * 
 * @author sitapsha
 *
 */
public class MaxFlightsInAir {

	public static void main(String[] args) {
		int[][] flightsTime = { { 5, 10 }, { 0, 20 }, { 20, 40 }, { 35, 45 } };
		Arrays.sort(flightsTime, (a1, a2) -> Integer.compare(a1[0], a2[0]));
		PriorityQueue<Integer> flightsInAir = new PriorityQueue<>();
		int maxCount = 0;
		for (int[] park : flightsTime) {
			while (!flightsInAir.isEmpty() && flightsInAir.peek() < park[0]) {
				flightsInAir.poll();
			}

			flightsInAir.add(park[1]);
			maxCount = Math.max(maxCount, flightsInAir.size());
		}
		System.out.println(maxCount);
	}

}
