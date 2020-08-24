package com.sagar.foobar;

public class Level1 {

	public static void main(String[] args) {
//		System.out.println(solution("abccbaabccba")); // aabaca aabaca
//		System.out.println(solution("abcabcabcabc")); // aabaca aabaca
//		System.out.println(solution("aaaababaaaababe"));

		System.out.println("====================");
		
		System.out.println(solution("aabbaaaabbaa"));
		sol("aabbaaaabbaa"); // aabaca aabaca
//		sol("abcabcabcabc"); // aabaca aabaca
//		sol("aaaababaaaababe");
	}

	public static int solutionA(String x) {

		char endChar = x.charAt(x.length() - 1);
		int startIndex = 0;
		int size = 0;
		int c = 0;
		while (true) {
			c++;
			size = x.substring(size).indexOf(endChar) + 1 + size;
			String s1 = x.replace(x.substring(startIndex, size), "");
			if (s1.isEmpty()) {
				System.out.println(c);
				return size;

			}
		}

	}

	public static int solution(String x) {

		int i = 1;
		int j = 0;
		int firstMatchingIndex = x.length();
		boolean firstMatchingFound = false;
		while (i < x.length()) {
			if (x.charAt(j) == x.charAt(i)) {
				if (!firstMatchingFound) {
					firstMatchingIndex = i; // patter starts matching from this index
					firstMatchingFound = true;
				}
				i++;
				j++;
			} else if (j > 0) { // if letters not matched then start matching from Oth index.
				j = 0;
				firstMatchingIndex = x.length();
				firstMatchingFound = false;
			} else { // if letters not matched and j == 0 than increment i
				i++;
			}
		}	
		return x.length() / firstMatchingIndex;// number of repeating pattern
	}

//	public static int solution(String x) {
//
//		// Since we need to divide len(x) in equal parts.
//		// So result has to be on eof the divisors
//		List<Integer> divisors = getDivisors(x.length());
//		for (Integer paternLength : divisors) {
//			if (hasPatterOfGivenlength(paternLength, x)) {
//				return x.length() / paternLength;
//			}
//		}
//		return 1;// no repeating pattern
//	}

//
//	private static boolean hasPatterOfGivenlength(int paternLength, String x) {
//		int startIndex = paternLength; // start index of seconnd pattern
//		while (startIndex < x.length()) {
//			int i = 0;
//			while (i < paternLength) {
//				if (x.charAt(i) != x.charAt(startIndex)) {
//					return false;
//				}
//				i++;
//				startIndex++;
//			}
//		}
//		return true;
//	}
//
//	private static List<Integer> getDivisors(int n) {
//		List<Integer> divisors = new ArrayList<>();
//		for (int i = 1; i <= n / 2; i++) {
//			if (n % i == 0) {
//				divisors.add(i);
//			}
//		}
//		return divisors;
//	}

	public static void sol(String s) {
		String p1 = "", p2 = "";
		for (int i = 0, j = s.length() - 1; i < s.length() && j >= 0; i++, j--) {
			p1 += s.charAt(i);
			p2 += s.charAt(j);
			if (i != 0)
				if (isPal(p1, p2)) {
					System.out.println(s.length()/p1.length());
					break;
				}
		}
	}

	public static boolean isPal(String p1, String p2) {
		int i = 0, j = p2.length() - 1;
		while (i < p1.length()) {
			if (p1.charAt(i) == p2.charAt(j)) {
				i++;
				j--;
			} else
				return false;
		}
		return true;
	}

}
