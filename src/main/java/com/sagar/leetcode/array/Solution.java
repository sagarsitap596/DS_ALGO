package com.sagar.leetcode.array;

class Solution {

	public static void main(String[] args) {

		int[] H = new int[100_000];
		for (int i = 0; i < 99999; i++) {
			H[i] = 9000;
		}
		H[99999] = 9001;

		System.out.println(new Solution().solution(H));
	}

	public long solution(int[] H) {

		H = removeTrimZeros(H);
		if (H.length == 0) {
			return 0;
		}
		if (H.length == 1) {
			return H[0];
		}
		int[] maxIndex = findMaxIndex(H, 0, H.length - 1);
		if (maxIndex[0] == maxIndex[1]) {
			if (maxIndex[0] == 0) {
				int[] rightMaxIndex = findMaxIndex(H, 1, H.length - 1);
				return (long) H[maxIndex[0]] + (long) ((long) H[rightMaxIndex[0]] * (long) (H.length - 1));
			} else if (maxIndex[0] == H.length - 1) {
				int[] leftMaxIndex = findMaxIndex(H, 0, H.length - 2);
				return (long) H[maxIndex[0]] + (long) ((long) H[leftMaxIndex[0]] * (long) (H.length - 1));
			} else {
				int[] leftMaxIndex = findMaxIndex(H, 0, maxIndex[0] - 1);
				int[] rightMaxIndex = findMaxIndex(H, maxIndex[0] + 1, H.length - 1);

				long leftSum = ((long) H[leftMaxIndex[0]] * (long) maxIndex[0])
						+ ((long) H[maxIndex[0]] * ((long) (H.length - maxIndex[0])));
				long rightSum = (H[maxIndex[0]] * (maxIndex[0] + 1))
						+ (H[rightMaxIndex[0]] * (H.length - maxIndex[0] - 1));

				return leftSum < rightSum ? leftSum : rightSum;
			}
		}
		if (maxIndex[0] == 0 && maxIndex[1] == H.length - 1) {
			return H.length * H[maxIndex[0]];
		} else {
			if (maxIndex[0] == 0) {
				int[] rightMaxIndex = findMaxIndex(H, maxIndex[1] + 1, H.length - 1);
				return (long) ((long) H[maxIndex[0]] * ((long) maxIndex[1] + 1))
						+ ((long) H[rightMaxIndex[0]] * (long) (H.length - maxIndex[1] - 1));
			} else if (maxIndex[1] == H.length - 1) {
				int[] leftMaxIndex = findMaxIndex(H, 0, maxIndex[0] - 1);
				return (long) ((long) H[leftMaxIndex[0]] * (long) maxIndex[0])
						+ (long) ((long) H[maxIndex[0]] * (long) (H.length - maxIndex[0]));
			} else {

				int[] leftMaxIndex = findMaxIndex(H, 0, maxIndex[0] - 1);
				int[] rightMaxIndex = findMaxIndex(H, maxIndex[1] + 1, H.length - 1);
				long leftSum = (long) ((long) H[leftMaxIndex[0]] * (long) maxIndex[0])
						+ (long) ((long) H[maxIndex[0]] * (long) ((H.length - maxIndex[0])));
				long rightSum = (long) ((long) H[maxIndex[0]] * (long) (maxIndex[1] + 1))
						+ (long) ((long) H[rightMaxIndex[0]] * (long) (H.length - maxIndex[1] - 1));

				return leftSum < rightSum ? leftSum : rightSum;

			}
		}
	}

	private int[] removeTrimZeros(int[] m) {

		int i = 0;
		while (i < m.length && m[i] == 0) {
			i++;
		}

		int j = m.length - 1;
		while (j >= 0 && m[j] == 0) {
			j--;
		}

		if (i > j) {
			return new int[] {};
		}
		int k = 0;
		int[] arr = new int[(j - i) + 1];
		while (i <= j) {
			arr[k] = m[i];
			i++;
			k++;
		}
		return arr;
	}

	private int[] findMaxIndex(int[] H, int startIndex, int endIndex) {
		int max = Integer.MIN_VALUE;
		int[] indexes = new int[] { -1, -2 };
		for (int i = startIndex; i <= endIndex; i++) {
			if (max < H[i]) {
				indexes[0] = indexes[1] = i;
				max = H[i];
			} else if (max == H[i]) {
				indexes[1] = i;
			}
		}
		return indexes;
	}
}