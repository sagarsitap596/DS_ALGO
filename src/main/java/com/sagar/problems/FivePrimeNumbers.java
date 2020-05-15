package com.sagar.problems;

/**
 * 
 * @author sitapsha <br>
 *         The primes 3, 7, 109, and 673, are quite remarkable. By taking any
 *         two primes and concatenating them in any order the result will always
 *         be prime. For example, taking 7 and 109, both 7109 and 1097 are
 *         prime. The sum of these four primes, 792, represents the lowest sum
 *         for a set of four primes with this property. Find the lowest sum for
 *         a set of five primes for which any two primes concatenate to produce
 *         another prime.
 *
 */
public class FivePrimeNumbers {

    static int[] ps = { 3, 7, 109, 673, -1 };

    public static void main(String[] args) {

        int n = 7;

        findPrimes(1);

        for (int i = 0; i < ps.length; i++) {

            System.out.print(ps[i] + " ");

        }
    }

    public static void findPrimes(int n) {

        int nxtPrime = 673;
        for (int i = 0; i < n; i++) {

            nxtPrime = findNxtPrime(nxtPrime);
            while (!isSmallestSumPrime(nxtPrime)) {
                nxtPrime = findNxtPrime(nxtPrime);
            }
        }
        ps[ps.length - 1] = nxtPrime;
    }

    public static int findNxtPrime(int n) {

        n = n + 2;

        while (!isPrime(n)) {

            n = n + 2;
        }
        return n;
    }

    public static boolean isPrime(int n) {

        System.out.print("");
        for (int i = 3; i < n / 2; i++) {
            if (n % i == 0) {
                System.out.print("    -------  "+n +" >> " + i);
                System.out.println();
                return false;
            }
        }

        return true;
    }

    public static boolean isSmallestSumPrime(int n) {

        System.out.print("isSmallestSumPrime : " + n);
        int sum = n;
        for (int i = 0; i < ps.length - 1; i++) {
            sum = ps[i];
            if (!isPrime(Integer.parseInt(ps[i] + "" + n)) || !isPrime(Integer.parseInt(n + "" + ps[i]))) {
                return false;
            }

        }
        if (!isPrime(sum)) {
            return false;
        }
        return true;

    }
}