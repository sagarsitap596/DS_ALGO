package com.sagar.leetcode.array;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(28));
		System.out.println(solution(734));
		System.out.println(solution(1990));
		System.out.println(solution(1000));
	}

	public static int solution(int N) {
		int sum = calculateSum(N);

		N = N + 1;
		while (calculateSum(N) != sum) {
			N++;
		}
		return N;

	}

	private static int calculateSum(int n) {
		int sum = 0;
		while (n != 0) {
			sum = sum + n % 10;
			n = n / 10;
		}
		return sum;
	}

}
