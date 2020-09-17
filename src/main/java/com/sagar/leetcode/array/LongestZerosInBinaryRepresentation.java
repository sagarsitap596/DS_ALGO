package com.sagar.leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class LongestZerosInBinaryRepresentation {

	public static void main(String[] args) {
		System.out.println(solution(9));
	}

	public static int solution(int N) {
		String str = Long.toBinaryString(N);
		List<Integer> onesIndex = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if ('1' == str.charAt(i)) {
				onesIndex.add(i);
			}
		}

		if (onesIndex.isEmpty() || onesIndex.size() == 1)
			return 0;

		int max = 0;
		for (int i = 1; i < onesIndex.size(); i++) {
			if (max < onesIndex.get(i) - onesIndex.get(i - 1)) {
				max = onesIndex.get(i) - onesIndex.get(i - 1);
			}
		}
		return max - 1;
	}

}
