package com.sagar.recursion;


/**
 * InterweavingStrings means merge 2 strings and form third string by
 * alternating their letters. But relative ordering of those letter should
 * remain same in third string
 * 
 * Eg
 * s1 = abc
 * s2 = 123
 * 
 * s3 = a1b2c3 , abc123, 123abc ,ab123c ,12a3bc --- InterweavingStrings
 * s3 = a1b3c2 -- not InterweavingStrings
 * 
 * @author sitapsha
 *
 */
public class InterweavingStrings {

	public static void main(String[] args) {
		// System.out.println(checkWithoutCaching("abcd", "xyz", "abcd", 0, 0));

		String one = "aaaaab";
		String two = "aaaaac";
		String three = "aaaaaaaaaacb";

		if ((one.length() + two.length()) != three.length())
			System.out.println(false);
		else {
			System.out.println(checkWithoutCaching(0, 0, one, two, three));
		}

		if ((one.length() + two.length()) != three.length())
			System.out.println(false);
		else {
			Boolean[][] visited = new Boolean[one.length() + 1][two.length() + 1];
			System.out.println(check(0, 0, one, two, three, visited));
		}

	}

	/*
	 * 
	 * Time complexity is O( 2 ^ (n + m)) at each step we got two paths , either to
	 * go with string one or two Space complexity is O (n+m) Recursion stacks up
	 * utmost n+m values worst case, where we traverse whole string one and find
	 * that its not correct and go bacj each step and traverse string two and so on
	 * 
	 */
	private static boolean checkWithoutCaching(int i, int j, String one, String two, String three) {

		int k = i + j;
		if (k == three.length())
			return true;

		if (i < one.length() && one.charAt(i) == three.charAt(k)) {
			if (checkWithoutCaching(i + 1, j, one, two, three)) { // this required bcz if it returns false, we should
																	// check for string
																	// if return check(i+1, j, one, two, three)
																	// directly, than in case string two
																	// is not matched with string 3 we would not check
																	// for string two and three and
																	// directly return false
				return true;
			}
		}
		if (j < two.length() && two.charAt(j) == three.charAt(k)) {
			return checkWithoutCaching(i, j + 1, one, two, three);
		}
		return false;
	}

	private static boolean check(int i, int j, String one, String two, String three, Boolean[][] visited) {

		if (visited[i][j] != null)
			return visited[i][j];

		int k = i + j;
		if (k == three.length())
			return true;

		if (i < one.length() && one.charAt(i) == three.charAt(k)) {
			visited[i][j] = check(i + 1, j, one, two, three, visited);
			if (visited[i][j]) { // this required bcz if it returns false, we should check for string
									// if return check(i+1, j, one, two, three) directly, than in case string two
									// is not matched with string 3 we would not check for string two and three and
									// directly return false
				return true;
			}
		}
		if (j < two.length() && two.charAt(j) == three.charAt(k)) {
			visited[i][j] = check(i, j + 1, one, two, three, visited);
			return visited[i][j];
		}
		return false;
	}

}
