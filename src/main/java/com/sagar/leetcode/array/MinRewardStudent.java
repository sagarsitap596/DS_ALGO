package com.sagar.leetcode.array;

public class MinRewardStudent {

	public static void main(String[] args) {

		System.out.println(minRewards2(new int[] { 8, 4, 2, 1, 3, 6, 7, 9, 5}));

	}

	public static int minRewards(int[] scores) {

		if (scores.length == 1)
			return 1;
		int[] reward = new int[scores.length];
		reward[0] = scores.length;
		int minReward = reward[0];
		for (int i = 1; i < scores.length; i++) {

			if (scores[i] > scores[i - 1]) {
				reward[i] = reward[i - 1] + 1;
			} else {
				reward[i] = reward[i - 1] - 1;
			}
			if (minReward > reward[i]) {
				minReward = reward[i];
			}
		}

		// Subrtact minReward-1 from all the rewards so that min reward given is 1.
		minReward--;
		int sum = 0;
		if (reward[0] < reward[1]) {
			reward[0] = 1;
		}
		if (reward[scores.length - 1] < reward[scores.length - 2]) {
			reward[scores.length - 1] = 1;
		}
		for (int i = 0; i < scores.length; i++) {
			if (reward[i] > 1) {
				reward[i] = reward[i] - minReward;
			}
			sum = sum + reward[i];
		}
		return sum;
	}
	//8, 4, 2, 1, 3, 6, 7, 9, 5
	public static int minRewards2(int[] scores) {

		if (scores.length == 1)
			return 1;

		int[] rewards = new int[scores.length];

		for (int i = 1; i < scores.length; i++) {
			if (scores[i - 1] < scores[i]) {
				rewards[i] = rewards[i - 1] + 1;
			}
		}

		if (rewards[scores.length - 1] < rewards[scores.length - 2]) {
			rewards[scores.length - 1] = 0;
		}

		for (int i = scores.length - 2; i >= 0; i--) {
			if (scores[i] > scores[i + 1]) {
				rewards[i] = Math.max(rewards[i + 1] + 1, rewards[i]);
			}
		}

		int sum = 0;
		for (int i = 0; i < rewards.length; i++) {
			sum = sum + rewards[i];
		}
		return sum + scores.length;
	}

}
