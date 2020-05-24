package com.sagar.problems;

/**
 * gcd of a b c d is gcd(gcd(gcd(a,b),c),d)
 * 
 * @author sitapsha
 *
 */
public class GCD {

	public static void main(String[] args) {

		int arr[] = { 4, 56, 8, 24, 56 };
		
//		int arr[] = { 60,96 };
//		
//		int arr[] = { 20,8 };

		int gcd = arr[0];

		for (int j = 1; j < arr.length; j++) {
			gcd = gcd(gcd, arr[j]);
		}

		System.out.println(gcd);
	}

	/**
	 * 
	 * Euclid algo divide a / b. a=b b=remainder
	 * 
	 * Till remainder is zero.
	 * 
	 */
	public static int gcd(int a, int b) {
		int remainder;
		while (b > 0) {
			remainder = a % b;
			a = b;
			b = remainder;
		}
		return a;
	}
}
