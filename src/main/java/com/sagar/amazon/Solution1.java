package com.sagar.amazon;

import java.util.List;
import java.util.stream.Collectors;

public class Solution1 {

	public static void main(String[] args) {
		System.out.println(variantsCount2(60000000, 9, 60306849, 729789559, 11, 2500001627076924l));
//		System.out.println("-------------");
		System.out.println(variantsCount3(60000000, 9, 60306849, 729789559, 11, 2500001627076924l));
//		System.out.println("-------------");
//		System.out.println(variantsCount(60000000, 9, 60306849, 729789559, 11, 2500001627076924l));
		System.out.println(variantsCount3(3, 1, 1, 1, 2, 100));
		System.out.println(variantsCount2(3, 1, 1, 1, 2, 100));

	}

//	public static int findMinComplexity(List<Integer> complexity, int days) {
//
//        if(days >= complexity.size()){
//            return complexity.stream().collect(Collectors.summingInt(Integer::intValue));
//        }
//    }

	public static long variantsCount(int n, int s0, int mul, int offset, int modVal, long a) {
		long[] sizes = new long[n];
		sizes[0] = s0;
		for (int i = 1; i < n; i++) {
			sizes[i] = ((mul * sizes[i - 1] + offset) % modVal) + 1 + sizes[i - 1];
		}
//		System.out.println(sizes.length);
		long variantsCount = 0;
		outerloop: for (int row = 0; row < sizes.length; row++) {
			for (int col = row; col < sizes.length; col++) {
				if (sizes[row] * sizes[col] <= a) {
					if (row == col) {
						variantsCount++;
					} else {
						variantsCount += 2;
					}
				} else if (row == col) {
					break outerloop;
				} else {
					break;
				}
			}
		}
		return variantsCount;
	}

	public static long variantsCount2(int n, int s0, int mul, int offset, int modVal, long a) {
		long[] sizes = new long[n];
		sizes[0] = s0;
		for (int i = 1; i < n; i++) {
			sizes[i] = ((mul * sizes[i - 1] + offset) % modVal) + 1 + sizes[i - 1];
		}
//		System.out.println(sizes[sizes.length - 1]);

		long variantsCount = 0;
		int end = sizes.length - 1;
		for (long size : sizes) {
			long s = a / size;
			int nn = getTotalNumberLessThanOREqualTo(s, sizes, end);
			end = nn - 1;
			variantsCount = variantsCount + nn;
		}
		return variantsCount;
	}

	public static long variantsCount3(int n, int s0, int mul, int offset, int modVal, long a) {
		long[] sizes = new long[n];
		sizes[0] = s0;
		for (int i = 1; i < n; i++) {
			sizes[i] = ((mul * sizes[i - 1] + offset) % modVal) + 1 + sizes[i - 1];
		}
//		System.out.println(sizes[sizes.length - 1]);

		return fun(sizes, sizes.length, a);
	}

	private static int getTotalNumberLessThanOREqualTo(long s, long[] sizes, int end) {
		int left = 0;
		int right = end;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (sizes[mid] == s) {
				return mid + 1;
			}
			if (s > sizes[mid]) {
				left = mid + 1;
			} else {
				if (mid > 0 && sizes[mid - 1] > s) {
					return mid;
				} else {
					right = mid - 1;
				}

			}
		}
		if (right == end)
			return sizes.length;
		return -1;
	}

	static int fun(long arr[], int n, long x) {

		int l = 0, r = n - 1;
		int result = 0;

		int count = 0;
		while (l <= r) {

			// If current left and current
			// right have sum smaller than x,
			// the all elements from l+1 to r
			// form a pair with current l.
			if (arr[l] * arr[r] < x) {
				result += (r + 1);

			} else {
				result += arr.length;
			}
			r--;

		}

		return result;
	}

}
