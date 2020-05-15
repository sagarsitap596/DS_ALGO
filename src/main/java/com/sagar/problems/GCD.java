package com.sagar.problems;

/**
 * gcd of a b c d is gcd(gcd(gcd(a,b),c),d)
 * 
 * @author sitapsha
 *
 */
public class GCD {

    public static void main(String[] args) {

        int arr[] = { 56, 4, 8, 24, 56 };

        int gcd = arr[0];

        for (int j = 1; j < arr.length; j++) {
            gcd = gcd(gcd, arr[j]);
        }

        System.out.println(gcd);
    }
    
//    public static int findGCD(int[] arr,int k) {
//        
//    }

    public static int gcd(int n1, int n2) {
        int remainder;
        while (n1 > 0) {
            remainder = n2 % n1;
            n2 = n1;
            n1 = remainder;
        }
        return n2;
    }
}
