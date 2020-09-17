package com.sagar.dynamicproblem;

public class SubSetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[] { 2, 8 };
		int targetSum = 10;

		boolean[] sumStatus1 = new boolean[targetSum + 1];

		sumStatus1[0] = true;
		boolean[] sumStatus2 = sumStatus1.clone();
		for (int n : array) {

			for (int sum = 1; sum < sumStatus1.length; sum++) {
				if (n <= sum) {
					if (sumStatus2[sum]) {
						sumStatus1[sum] = true;
					} else {
						sumStatus1[sum] = sumStatus2[sum - n];
					}
				}
			}
			boolean[] sumStatus = sumStatus1;
			sumStatus1 = sumStatus2;
			sumStatus2 = sumStatus;
		}
		System.out.println(sumStatus1[targetSum] || sumStatus2[targetSum]);
	}

}
