package com.sagar.problems;

/**
 * 
 * step 1 : Decide breaking condition.
 * step 2 : check how iteration will happen wit the login.
 * E.g.
 * 1.countDown is single variable operation(decrement). so call itself with (value-1)
 * 2.power is two variable operation (n ^ pow). we have to multiply n with n for pow times. So our
 *   n should be return by function every time for pow number of times.
 * 
 * 3.factorial is two variable operation (multiply n with (n-1) *(n-2) *(n-3) *(n-4) ... * 1).
 * So function should return n-1 for given n each time.
 * 
 * @author sitapsha
 *
 */
public class RecursionExample {

	public static void main(String[] args) {
		countDown(4);
		System.out.println("===========================");
		System.out.println(power(2, 4));
		System.out.println("===========================");
		System.out.println(factorial(4));
		System.out.println("===========================");
		System.out.println(evenfactorial(8));
		System.out.println("===========================");
		System.out.println(findMax(new int[] { 101, 2, 3 }, 0));

	}

	private static void countDown(int n) {
		if (n == 0) {
			System.out.println("Done!!!!!");
			return;
		} else {
			System.out.println(n);
			countDown(n - 1);
			System.out.println("foo");
		}
	}

	/**
	 * 2 ^ 4 = 2 x 2 x 2 x 2
	 */
	private static int power(int n, int pow) {
		if (pow == 0) {
			return 1;
		} else {
			return n * power(n, pow - 1);
		}
	}

	private static int factorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}

	private static int evenfactorial(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * evenfactorial(n - 2);
		}
	}

	private static int findMax(int[] arr, int startIndex) {

		if (startIndex == arr.length - 1) {
			return arr[startIndex];
		}

		int n1 = arr[startIndex];
		int n2 = findMax(arr, startIndex + 1);

		if (n1 > n2) {
			return n1;
		} else
			return n2;
	}

}
